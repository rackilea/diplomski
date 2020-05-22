public class BookResourceTest {

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
    public void testBookResourceLinks() throws Exception {
        String BASE_URL = "http://localhost:8080/jaxrs-stackoverflow-book/rest/books/3";
        WebTarget target = client.target(BASE_URL);
        String xmlResult = target.request().accept(MediaType.APPLICATION_XML).get(String.class);
        System.out.println(xmlResult);

        Unmarshaller unmarshaller = JAXBContext.newInstance(BookStore.class).createUnmarshaller();
        BookStore bookStore = (BookStore)unmarshaller.unmarshal(new StringReader(xmlResult));
        URI next = bookStore.getNext();

        WebTarget nextTarget = client.target(next);
        String xmlNextResult = nextTarget.request().accept(MediaType.APPLICATION_XML).get(String.class);
        System.out.println(xmlNextResult);
    }
}