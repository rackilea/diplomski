public class MyService {
    private static final String MYSERVER = "http://testserver:9086";

    public URLConnection createConnection(Properties properties) throws MalformedURLException, IOException {
        return new URL(MYSERVER).openConnection();
    }
}