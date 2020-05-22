public class MyJSONRequest extends AsyncTask<Void, Void, Void> {

    String url;
    String method;
    List<NameValuePair> params;

    public MyJSONRequest(String url, String method, List<NameValuePair> params) {
        this.url = url;
        this.method = method;
        this.params = params;
    }

    @Override
    public Void doInBackground(Void...) {
        makeHttpRequest(url, method, params)
    }
}