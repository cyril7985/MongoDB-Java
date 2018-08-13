/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dl.mongo3libs;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Administrateur
 */
public class TestsPrealablesTests {

    public static void main(String[] args) {

        String lsDb = "cours";
        String collection = "";

        try {

            //public static MongoClient getConnexion(String user, String pwd, String ip, String dbName)
            //MongoClient mc = ConnexionMongoDB.getConnexion("cyril7985", "loubna1985", "185.31.40.41", "cyril7985_cours");
            MongoClient mc = ConnexionMongoDB.getConnexion("127.0.0.1");

            // public static MongoDatabase getDB(MongoClient mongoClient, String dbName)             
            //MongoDatabase mdb = ConnexionMongoDB.getDB(mc, "cours");
            // public static Boolean DBExist(MongoClient mongoClient, String dbName) 
            boolean lbDbExist = TestsPrealables.DBExist(mc, lsDb);
           // boolean collectionExist = TestsPrealables.collectionExist(collection, lsDb);
            if (lbDbExist) {
                System.out.println("La BD " + lsDb + " existe");
            } else {
                System.out.println("La BD " + lsDb + " n'existe pas ");
            }

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
