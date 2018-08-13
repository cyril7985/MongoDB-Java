package fr.dl.mongo3libs;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnexionMongoDB {

    /**
     *
     * @param user
     * @param pwd
     * @param ip
     * @param dbName
     * @return
     */
    public static MongoClient getConnexion(String user, String pwd, String ip, String dbName) {

        MongoClient mdbClient = null;
        String lsURL = "mongodb://" + user + ":" + pwd + "@" + ip + "/" + dbName;
        MongoClientURI uri;

        try {
            uri = new MongoClientURI(lsURL);
            mdbClient = new MongoClient(uri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mdbClient;
    } /// getConnexion

    /**
     *
     * @param ip
     * @param dbName
     * @return
     */
    public static MongoClient getConnexion(String ip) {

        MongoClient mongoClient = null;
        try {

            mongoClient = new MongoClient(ip, 27017);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mongoClient;
    } /// getConnexion

    /**
     *
     * @param mongoClient
     * @param dbName
     * @return
     */
    public static MongoDatabase getDB(MongoClient mongoClient, String dbName) {

        //String lsDBName = "m2icdi_musik";
        MongoDatabase db = null;

        try {
            // La BD
            db = mongoClient.getDatabase(dbName);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }

        return db;
    } /// getDB

    /**
     *
     * @param mongoClient
     * @return
     */
    public static boolean closeConnexion(MongoClient mongoClient) {
        boolean lbOK = true;

        try {
            mongoClient.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            lbOK = false;
        }
        return lbOK;
    } /// closeConnexion

} /// class

