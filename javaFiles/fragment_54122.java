public class HttpsUrlConnectionProvider {
    public HttpsURLConnection getHttpsURLConnection(String dialogUri) throws IOException {
        URL url = new URL(dialogUri);
        return (HttpsURLConnection) url.openConnection();
    }
}