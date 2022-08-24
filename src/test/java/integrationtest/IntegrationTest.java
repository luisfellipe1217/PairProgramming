package integrationtest;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import dao.DbActions;
import dao.MongoConnectionDAO;
import model.User;
import model.UserBuilder;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.JVM)
public class IntegrationTest {

    private static User userTest = UserBuilder.anUser().userId(1).userName("Teste").isAManager().finalUser();

    private static MongoConnectionDAO connection = new MongoConnectionDAO();
    private static DbActions dbActions = new DbActions();



    @Test
    public void insertObjectTest() {

        dbActions.insertObject(userTest.getId(), userTest.getName(), userTest.getFunction(), userTest.getSalary(), connection);
        DBObject query = new BasicDBObject("cod", userTest.getId());
        DBCursor cursor = connection.getUsers().find(query);

        Assert.assertThat(cursor.one().toString(), Matchers.containsString(userTest.getName()));
    }

    @Test
    public void findObjectTest(){

        String user = dbActions.findObject(userTest.getId(), connection).one().toString();

       Assert.assertThat(user, Matchers.containsString(userTest.getName()));
    }

    @AfterClass
    public static void tearDown() {
        connection.connect();
        DBObject query = new BasicDBObject("cod", userTest.getId());
        connection.getUsers().remove(query);

    }
}
