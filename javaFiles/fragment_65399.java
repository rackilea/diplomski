public class Client {

    // This interface will be used in your get() method, and implement in your first snippet
    public interface MyClientCallback {
        public void onResponse(String value);
    }

    // Add your interface as param
    public void get(MyClientCallback callback) {

        ```
        // prova = response.toString();
        callback.onReponse(response.toString());
        ```

    }
}