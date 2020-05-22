public class MyApi {
    final String myUrl;
    public MyApi(String urlString) {
        // Verify that urlString points to an approved server
        if (!checkApprovedUrl(urlString)) throw new IllegalArgumentException();
        myUrl = urlString;
    }
}