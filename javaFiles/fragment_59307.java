public class HTTPPostActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    makePostRequest();

}
private void makePostRequest() {


    HttpClient httpClient = new DefaultHttpClient();
                            // replace with your url
    HttpPost httpPost = new HttpPost("www.example.com"); 


    //Post Data
    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
    nameValuePair.add(new BasicNameValuePair("username", "test_user"));
    nameValuePair.add(new BasicNameValuePair("password", "123456789"));


    //Encoding POST data
    try {
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
    } catch (UnsupportedEncodingException e) {
        // log exception
        e.printStackTrace();
    }

    //making POST request.
    try {
        HttpResponse response = httpClient.execute(httpPost);
        // write response to log
        Log.d("Http Post Response:", response.toString());
    } catch (ClientProtocolException e) {
        // Log exception
        e.printStackTrace();
    } catch (IOException e) {
        // Log exception
        e.printStackTrace();
    }

}

}