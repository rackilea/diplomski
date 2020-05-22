public class MyClass {

    private final MySender sender;

    public MyClass() {
        this(new DefaultSender());
    }

    public MyClass(MySender sender) {
        this.sender = sender;
    }

    public MyResponseObject doStuff(MyRequestObject obj) {
        Response res = sender.sendRequest(obj.toString());
        if (response.getStatus() == 200) {
            String jsonResp = response.readEntity(String.class);
            return convertToObj(jsonResp);
        }
    }

    public interface MySender {
        Response sendRequest(String json);
    }

    private static class DefaultSender implements MySender {
        public Response sendRequest(String json) {
            WebTarget tar = getServiceClient().target(someUrl);
            return res = tar.path(someURI).request().post(somejson);
        }
    }
}

@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    private MyClass testSubject;

    @Mock
    private MySender sender;

    @Mock
    private Response response;

    @Test
    public void testDoStuff() {
        String expectedResp = ...;
        MyRequestObject request = ...;
        MyResponseObject  response = testSubject.doStuff(request);

        assertEquals(response.toString(),expectedResp);
    }

    @Before
    public void setup() {
        testSubject = new MyClass(sender);
        when(sender.sendRequest(anyString()).thenReturn(response);
        when(response.getStatus()).thenReturn(200);
        when(response.readEntity()).thenReturn("OK");
    }
}