package org.ucm.tp;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejemplo1 {

	public static void main(String[] args) {
		/* 1- conexión*/
		//MongoClient mongoClient = MongoClients.create();
		//MongoClient mongoClient = MongoClients.create("mongodb://hostOne:27017,hostTwo:27018");

		MongoClient mongoClient = MongoClients.create(
		        MongoClientSettings.builder()
		                .applyToClusterSettings(builder ->
		                        builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
		                .build());
		
		/* 2- inserto profesor*/
		 MongoDatabase database = mongoClient.getDatabase("facultad");
		 MongoCollection<Document> collection = database.getCollection("clases");

		 Document doc = new Document("clase", "TP")
	                .append("grupo", "C")
	                .append("curso", 1)
	                .append("aulas", Arrays.asList("6", "lab10"))
	                .append("profesores", Arrays.asList(new Document("nombre", "javier")
	                						.append("apellidos", "Gómez")
	                						.append("plaza","profesor asociado")));
		 
		 collection.insertOne(doc);

	}

}
