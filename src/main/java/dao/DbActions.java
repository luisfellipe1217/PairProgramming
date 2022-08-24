package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class DbActions {


    public void insertObject(int cod, String name, String function, double salary, MongoConnectionDAO connection) {
        connection.connect();
        connection.getUsers().insert(convert(cod, name, function, salary));
    }

    public DBCursor findObject(int cod, MongoConnectionDAO connection) {
        connection.connect();
        DBObject query = new BasicDBObject("cod", cod);
        return connection.getUsers().find(query);
    }

    public void printObject(int cod, MongoConnectionDAO connection) {
        connection.connect();
        System.out.println(findObject(cod, connection).one());
    }

    public DBObject convert(int cod, String function, String name, double salary) {
        return new BasicDBObject("cod", cod).append("name", name).append("function", function).append("salary", salary);
    }
}
