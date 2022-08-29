package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.math.BigDecimal;

public class DbActions {

    private final MongoConnectionDAO connection;

    public DbActions(){
        this.connection = new MongoConnectionDAO();
        try {
            setConnection();
        }catch (Exception ignored){
        }
    }

    public DbActions(MongoConnectionDAO connection){
        this.connection = connection;
        try {
            setConnection();
        }catch (Exception ignored){
        }
    }

    private void setConnection() throws Exception {
        connection.connect();
    }


    public void insertObject(Integer cod, String name, String function, BigDecimal salary) {
        connection.getUsers().insert(convert(cod, name, function, salary));
    }

    public DBCursor findObject(Integer cod) {
        DBObject query = new BasicDBObject("cod", cod);
        return connection.getUsers().find(query);
    }

    public void printObject(Integer cod) {
        System.out.println(findObject(cod).one());
    }

    public DBObject convert(Integer cod, String function, String name, BigDecimal salary) {
        return new BasicDBObject("cod", cod).append("name", name).append("function", function).append("salary", salary);
    }
}
