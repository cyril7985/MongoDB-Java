package fr.cl.mongo3;

/**
 * Lister le contenu d'une collection
 *
 * La collection « produits » de la BD « cours »
 */
import fr.dl.mongo3libs.ConnexionMongoDB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class DocumentsListOfProduits {

    public static void main(String[] args) {

        String lsDBName = "cyril7985_cours";
       //boolean lbDBExist = false;
        String lsCollectionName = "produits";
        boolean lbCollectionExist = false;

        try {
            // Connexion a mongoDB
            MongoClient mongoClient = ConnexionMongoDB.getConnexion("cyril7985","loubna1985","mongodb-cyril7985.alwaysdata.net",lsDBName);
            
           
            

            // Une BD
            MongoDatabase db = mongoClient.getDatabase(lsDBName);
            
           
            

            /*
            Les BD
            */
//            MongoIterable<String> listeDB = mongoClient.listDatabaseNames();
//
//            MongoCursor<String> it = listeDB.iterator();
//            while (it.hasNext()) {
//                String lsDB = it.next();
//                if (lsDB.equals(lsDBName)) {
//                    lbDBExist = true;
//                }
//            }
              // ALTERNATIVE ...
//            for (String lsDB : listeDB) {
//                //System.out.println(lsDB);
//                if (lsDB.equals(lsDBName)) {
//                    lbDBExist = true;
//                }
//            }

//            if (lbDBExist) {
                MongoCollection collection = db.getCollection(lsCollectionName);
                //System.out.println(collection);

                /*
                 Les collections
                 */
                MongoIterable<String> collectionListe = db.listCollectionNames();
                for (String lsCollection : collectionListe) {
                    if (lsCollection.equals(lsCollectionName)) {
                        lbCollectionExist = true;
                    }
                }

                /*
                 Balayage du curseur
                 */
                if (lbCollectionExist) {
                    FindIterable<Document> curseur = collection.find();
                    for (Document document : curseur) {
                        System.out.println(document.get("designation"));
                    }
                } else {
                    System.out.println("La collection " + lsCollectionName + " n'existe pas");
                }
//            } else {
//                System.out.println("La BD " + lsDBName + " n'existe pas !");
//            }

            // Fermeture de la connexion au serveur
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    } /// main

} /// class
