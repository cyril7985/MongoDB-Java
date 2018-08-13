package fr.dl.mongo3libs;

import com.mongodb.MongoClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrateur
 */
public class ConnexionMongoDBTest {

    public static void main(String[] args) {

        try {

            //public static MongoClient getConnexion(String user, String pwd, String ip, String dbName)
            MongoClient mc = ConnexionMongoDB.getConnexion("cyril7985", "loubna1985", "185.31.40.41", "cyril7985_cours");

            // public static MongoDatabase getDB(MongoClient mongoClient, String dbName)             
            ConnexionMongoDB.getDB(mc, "cyril7985_cours");

            //public static boolean closeConnexion(MongoClient mongoClient)
            boolean lbClose = ConnexionMongoDB.closeConnexion(mc);

            if (lbClose) {
                System.out.println("Maison close");

            } else {
                System.out.println("Maison open");

            }
        } catch (Exception e) {
        }

    }

}
