/*
Les communes sur alwaysdata
 */
package fr.cl.mongo3;

import com.mongodb.BasicDBObject;
import fr.dl.mongo3libs.ConnexionMongoDB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Aggregates.limit;
import org.bson.Document;

/**
 *
 * @author Pascal
 */
public class ListPaysAD {

    public static void main(String[] args) {
        String lsDBName = "cyril7985_cours";
        String lsUser = "cyril7985";
        String lsPWD = "loubna1985";
        String lsIP = "185.31.40.41";
        String lsCollectionName = "communes";
        boolean lbCollectionExist = false;

        try {
            // Connexion a mongoDB
            //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            MongoClient mongoClient = ConnexionMongoDB.getConnexion(lsUser, lsPWD, lsIP, lsDBName);

            // Une BD
            MongoDatabase db = mongoClient.getDatabase(lsDBName);

            /*
            La collection recherchée
             */
            MongoCollection collection = db.getCollection(lsCollectionName);
            //System.out.println(collection);

            /*
                 Les collections de la DB
             */
            // On commence par vérifier que la collection recherchée existe dans la DB
            //Le "for each" permet de faire défiler la liste des collections
            MongoIterable<String> collectionListe = db.listCollectionNames();
            for (String lsCollection : collectionListe) {
                // System.out.println(lsCollection);
                if (lsCollection.equals(lsCollectionName)) {
                    lbCollectionExist = true;
                }
            }

            /*
                 Balayage du curseur
             */
            if (lbCollectionExist) {
                FindIterable<Document> curseur = collection.find();
                for (Document document : curseur) {//on balaye les collections avec le curseur
                    // nomVille,codePostal,codeCommune
                    System.out.println(document.get("nomVille"));
                }
            } else {
                System.out.println("La collection " + lsCollectionName + " n'existe pas");
            }

            /*
            UNE COMMUNE
             */
            System.out.println("***** Une commune *****");
            String lsNomCommune = "Sarlat-la-Canéda";

            // Creation d'un objet de type filtre
            //BasicDBObject critere = new BasicDBObject("nomVille", lsNomCommune); //les 2 méthodes sont bonnes pour créer un critère de select
             Document critere = new Document("nomVille", lsNomCommune);
           // Document critere = new Document ({} , { nomVille : 1}).limit(5);       //Donc soit "BasicDBObject" ou soit "Document"
           
           FindIterable<Document> iterateur = collection.find(critere);
            for (Document document : iterateur) {
                System.out.println(document.get("codePostal") + " : " + document.get("codeCommune"));
            }

            // Fermeture de la connexion au serveur
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
} /// ListCommunesAD

