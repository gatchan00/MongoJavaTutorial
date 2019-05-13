package org.ucm.tp.pojos;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class EjemploPojo1 {

	public static void main(String[] args) {
		
		/*ESTO ES para registrar los codecs*/
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		//abro clúster
		MongoClient mongoClient = MongoClients.create(
		        MongoClientSettings.builder()
		                .applyToClusterSettings(builder ->
		                        builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
		                .build());
		
		/* 2- inserto profesor*/
		 MongoDatabase database = mongoClient.getDatabase("facultad").withCodecRegistry(pojoCodecRegistry);;
		 MongoCollection<Clase> collection = database.getCollection("clases_pojo",Clase.class);

		 Profesor profe = new Profesor("Javier", "Gómez", "Profesor Asociado");
		 Clase clase = new Clase("TP","C",1,
				 Arrays.asList("6","lab10"),
				 Arrays.asList(profe)
				 );
 

		 
		 collection.insertOne(clase);
	}

}
