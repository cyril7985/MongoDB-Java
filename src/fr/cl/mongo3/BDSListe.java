package fr.cl.mongo3;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;

public class BDSListe {

    public static void main(String[] args) {

        try {
            // Connexion a mongoDB
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            /*
             Les BD
             */
            MongoIterable<String> listeDB = mongoClient.listDatabaseNames();

//            MongoCursor<String> it = listeDB.iterator();
//            while (it.hasNext()) {
//                String lsDB = it.next();
//                System.out.println(lsDB);
//            }
            // ALTERNATIVE ...
            for (String lsDB : listeDB) {
                System.out.println(lsDB);
            }

            // Fermeture de la connexion au serveur
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }

    } /// main
} /// BDsListe
