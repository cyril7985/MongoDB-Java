package fr.cl.mongo3;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConnexionBd {

    public static void main(String[] args) {
        try {
            // Connexion a mongoDB
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase dbCours = mongoClient.getDatabase("cours");
            System.out.println(dbCours);
            // La deconnexion de la BD n'existe pas
            // Fermeture de la connexion au serveur
            mongoClient.close();
        } catch (Exception e) {  
            System.out.println("UnknownHostException : " + e.getMessage());
        }
    } /// main

} /// class
