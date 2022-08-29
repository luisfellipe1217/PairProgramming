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

import java.util.Objects;


@FixMethodOrder(MethodSorters.JVM)
public class IntegrationTest {

    private static final User userTest = UserBuilder.anUser().userId(1).userName("Teste").isAManager().finalUser();

    private static final MongoConnectionDAO connection = new MongoConnectionDAO();
    private static final DbActions dbActions = new DbActions(connection);



    @Test
    public void insertObjectTest() {

        dbActions.insertObject(userTest.getId(), userTest.getName(), userTest.getFunction(), userTest.getSalary());
        DBObject query = new BasicDBObject("cod", userTest.getId());

        try (DBCursor cursor = connection.getUsers().find(query)) {
            Assert.assertThat(Objects.requireNonNull(cursor.one()).toString(), Matchers.containsString(userTest.getName()));
        }
    }

    @Test
    public void findObjectTest(){

        String user = String.valueOf(dbActions.findObject(userTest.getId()).one());

       Assert.assertThat(user, Matchers.containsString(userTest.getName()));
    }

    @AfterClass
    public static void tearDown() {
        DBObject query = new BasicDBObject("cod", userTest.getId());
        connection.getUsers().remove(query);

    }
}
