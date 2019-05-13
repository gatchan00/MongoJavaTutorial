package org.ucm.tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
public class Ejemplo3 {
	static String patronString = "[0-3]?[0-9]/[0-2]?[0-9]/[0-9]{4}";
	static Pattern patron = Pattern.compile(patronString);

	public static Date stringToDate(String fechaRaw)  {
		if (!patron.matcher(fechaRaw).matches()) return new Date();
		Calendar cal = Calendar.getInstance();
		String[] fechaSplit = fechaRaw.split("/");

		cal.set(Integer.parseInt(fechaSplit[2]),
				(Integer.parseInt(fechaSplit[1])-1),
				Integer.parseInt(fechaSplit[0])
				,0,0,0);
		return cal.getTime();
	}
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create(
				MongoClientSettings.builder()
				.applyToClusterSettings(builder ->
				builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
				.build());

		/* 2-  */
		MongoDatabase database = mongoClient.getDatabase("facultad");
		MongoCollection<Document> collection = database.getCollection("alumnos");

		try { 
			BufferedReader bufferedReader =  new BufferedReader(
					new InputStreamReader(
							new FileInputStream("alumnos.csv"),
							"UTF8"));
			String line = "";

			//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  

			while((line = bufferedReader.readLine()) != null) {
				String[] campos = line.split(";");
				Document doc = new Document("clase", "TP");
				doc.append("nombre", campos[0]);
				doc.append("alta", stringToDate(campos[1]));
				if (campos.length>2) doc.append("baja",  stringToDate(campos[2]));

				//collection.insertOne(doc);
				Document filter = new Document("nombre", campos[0]);
				collection.replaceOne(filter, doc, (new ReplaceOptions()).upsert(true));

			}   
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("No he podido abrir el fichero");
			e.printStackTrace();
		}
	}

}
