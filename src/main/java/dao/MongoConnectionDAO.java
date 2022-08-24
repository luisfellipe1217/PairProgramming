package dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


public class MongoConnectionDAO {

    public static MongoClient mongoClient;
    public static DB database;
    public static String connection = "mongodb://localhost:27017";
    public static DBCollection users;

    public boolean connect() {

        mongoClient = new com.mongodb.MongoClient(new MongoClientURI(connection));
        database = mongoClient.getDB("Assignment");
        users = database.getCollection("users");

        return true;
    }

    public DBCollection getUsers() {
        return users;
    }

    public MongoConnectionDAO() {
    }
}
