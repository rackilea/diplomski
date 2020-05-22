@RunWith(PowerMockRunner.class)
@PrepareForTest({ URL.class, Scanner.class, HttpClient.class })
public class HttpClientTest {

    private static final String REQUEST_URL = "http://wwww.google.com";

    @Test
    public void getResponse_NormalResponse() throws Exception {

        String expectedResponse = "This is the expected response text!";
        URL url = PowerMockito.mock(URL.class);
        HttpURLConnection connection = PowerMockito
                .mock(HttpURLConnection.class);
        InputStream inputStream = PowerMockito.mock(InputStream.class);
        Scanner scanner = PowerMockito.mock(Scanner.class);

        PowerMockito.whenNew(URL.class).withArguments(REQUEST_URL)
                .thenReturn(url);
        PowerMockito.whenNew(Scanner.class).withArguments(inputStream)
                .thenReturn(scanner);
        PowerMockito.when(scanner.useDelimiter("\\A")).thenReturn(scanner);

        PowerMockito.when(url.openConnection()).thenReturn(connection);

        // Response code mocked here
        PowerMockito.when(connection.getResponseCode()).thenReturn(200);

        PowerMockito.when(connection.getInputStream()).thenReturn(inputStream);
        PowerMockito.when(scanner.hasNext()).thenReturn(true);
        PowerMockito.when(scanner.next()).thenReturn(expectedResponse);

        HttpClient httpClient = new HttpClient();
        String actualResponse = httpClient.getResponse(REQUEST_URL);

        Assert.assertEquals("Response is wrong!", expectedResponse,
                actualResponse);
    }
}