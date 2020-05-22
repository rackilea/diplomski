import org.junit.Before;
import org.junit.Test;
import play.libs.ws.WSClient;
import play.test.WithServer;

public class UserProfileTests extends WithServer {

    private WSClient ws;

    @Before
    public void injectWs() {
        ws = app.injector().instanceOf(WSClient.class);
    }

    @Test
    public void demographicTest() {
        System.out.println(ws);
    }
}