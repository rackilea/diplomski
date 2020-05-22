public class ServerConnection {

    private static final String BASE_URL = "http://10.203.58.11:8080/";

    private static SyncHttpClient client = new SyncHttpClient();

    public static void get(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
}