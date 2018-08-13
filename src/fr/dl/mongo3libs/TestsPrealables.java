package fr.dl.mongo3libs;


import fr.dl.mongo3libs.ConnexionMongoDB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrateur
 */
public class TestsPrealables {

    /**
     * 
     * @param mongoClient
     * @param dbName
     * @return 
     */
    public static Boolean DBExist(MongoClient mongoClient, String dbName) {

        Boolean dbExist = false;

        /*
        Connexion serveur et Recupération de la BD avec la fonction "get.db"
         */
        MongoDatabase db = ConnexionMongoDB.getDB(mongoClient, dbName);

        /*
        Controle de la BD
         */
        //listage des BD 
        MongoIterable<String> listeDB = mongoClient.listDatabaseNames();

        //Creation d'un "curseur"
        MongoCursor<String> it = listeDB.iterator();

        //Tant que le curseur lit
        while (it.hasNext()) {
            String lsDB = it.next();
            if (lsDB.equals(dbName)) {// Si dans le curseur, une BD a le même nom que celle recherchée
                dbExist = true;
            }
        }
        return dbExist;
    }//Boolean DBExist

    
    
     public static boolean collectionExist(String isCollectionName, MongoDatabase db) {
        boolean lbExist = false;

        MongoCollection collection = db.getCollection(isCollectionName);
        //System.out.println(collection);

        /*
                 Les collections
         */
        MongoIterable<String> collectionListe = db.listCollectionNames();
        for (String lsCollection : collectionListe) {
            if (lsCollection.equals(isCollectionName)) {
                lbExist = true;
            }
        }

        return lbExist;
    } /// collectionExist


}//main
