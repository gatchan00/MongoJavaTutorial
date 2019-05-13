package org.ucm.tp.pojos;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EjemploPojo2 {

	public static void main(String[] args) {
		/*ESTO ES para registrar los codecs*/
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		//abro cl�ster
		MongoClient mongoClient = MongoClients.create(
		        MongoClientSettings.builder()
		                .applyToClusterSettings(builder ->
		                        builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
		                .build());
		
		/* 2- inserto profesor*/
		 MongoDatabase database = mongoClient.getDatabase("facultad").withCodecRegistry(pojoCodecRegistry);;
		 MongoCollection<Clase> collection = database.getCollection("clases_pojo",Clase.class);

		 for (Clase i: collection.find()) {
			 System.out.println(i);
		 }
	}

}
