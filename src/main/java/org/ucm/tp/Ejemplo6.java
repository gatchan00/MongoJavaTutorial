package org.ucm.tp;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejemplo6 {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create(
				MongoClientSettings.builder()
				.applyToClusterSettings(builder ->
				builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
				.build());

		/* 2-  */
		MongoDatabase database = mongoClient.getDatabase("facultad");
		MongoCollection<Document> collection = database.getCollection("alumnos");
		
		collection.deleteMany(new Document());
		
		
		 for (Document cur : collection.find()) {
			    System.out.println(cur.toJson());
			}
	}

}
