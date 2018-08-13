package fr.cl.mongo3;

import com.mongodb.MongoClient;

public class ConnexionServeur {

    public static void main(String[] args) {
        try {
            // Connexion a mongoDB
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            System.out.println(mongoClient);

            // Fermeture de la connexion au serveur
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("UnknownHostException : " + e.getMessage());
        }

    } /// main

} /// class