package org.ucm.tp;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CacaDeLaVaca {

	public static void main(String[] args) {
		/* 1- conexión*/
		//MongoClient mongoClient = MongoClients.create();
		//MongoClient mongoClient = MongoClients.create("mongodb://hostOne:27017,hostTwo:27018");

		MongoClient mongoClient = MongoClients.create(
		        MongoClientSettings.builder()
		                .applyToClusterSettings(builder ->
		                        builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
		                .build());
		
		/* 2-  */
		 MongoDatabase database = mongoClient.getDatabase("axa");
		 MongoCollection<Document> collection = database.getCollection("permisos");
		 
		 Document filtroQuery = new Document( "group", "mediadores_toledo");
		 Document proyeccion = new Document();
		 Document filtroExtra = new Document();

		 for (Document cur : collection.find(filtroQuery)) {
			 proyeccion= (Document) cur.get("fields_filter" );
			 filtroExtra= (Document) cur.get("extra_filter" );
			    System.out.println(proyeccion);
			}
		 filtroQuery.putAll(filtroExtra);
		 for (Document cur : collection.find(filtroQuery).projection(proyeccion)) {
			    System.out.println(cur);
			}
	}


}
