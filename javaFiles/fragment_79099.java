public class BookTest {
    private static Client client;
    @BeforeClass
    public static void setUpClass() {
        client = ClientBuilder.newClient();
    }
    @AfterClass
    public static void tearDownClass() {
        client.close();
    }

    @Test
    public void testBookLink() {
        String BASE_URL
                = "http://localhost:8080/jaxrs-stackoverflow-user/rest/books";
        WebTarget target = client.target(BASE_URL);
        String result = target.request()
                .accept(MediaType.APPLICATION_XML).get(String.class);
        System.out.println(result);
    }
}