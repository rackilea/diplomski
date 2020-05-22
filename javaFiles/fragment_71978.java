import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.consol.citrus.TestCaseMetaInfo.Status;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;

public class MyFirstTest extends JUnit4CitrusTestDesigner {

    private static final int PORT = 9123;
    private static SocketServer socketServer;
    private static Thread socketThread;

    @BeforeClass
    public static void setUp() throws Exception {
        socketServer = new SocketServer(PORT);
        socketThread = new Thread(socketServer);
        socketThread.start();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        socketServer.shutdown();
        socketThread.join();
    }

    @Test
    @CitrusTest(name = "sendSpringIntegrationMessageTest")
    public void sendSpringIntegrationMessageTest() {
        status(Status.DRAFT);
        send("citrusServiceEndpoint").payload("Message 1");
        send("citrusServiceEndpoint").payload("Message 2");
    }

}