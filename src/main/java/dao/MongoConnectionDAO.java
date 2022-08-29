package dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


public class MongoConnectionDAO {

    private MongoClient mongoClient;
    private DB database;
    private static final String connection = "mongodb://localhost:27017";
    private static DBCollection users;

    public void connect() throws Exception{

        try {
            mongoClient = new com.mongodb.MongoClient(new MongoClientURI(connection));
            database = mongoClient.getDB("Assignment");
            users = database.getCollection("users");
        }catch (Exception e){
            throw new Exception("Not connected!");
        }
    }

    public DBCollection getUsers() {
        return users;
    }

    public MongoConnectionDAO() {
    }
}
