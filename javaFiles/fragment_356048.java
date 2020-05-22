public class PHPRequestRetriever extends AsyncTask<Object, Void, String> {

    public interface Listener {
        void handlePHPRequestFinished(String result);
    }

    private Listener listener = null;
    private Exception exception = null;

    public PHPRequestRetriever(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Object... params) {
        String data = "";
        String url = (String) params[0];
        ArrayList<NameValuePair> args = (ArrayList<NameValuePair>) params[1];
        InputStream is = null;

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(args));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

        } catch (Exception e) {
            Log.e("PHPRequestRetriever", "Error in http connection " + e.toString());
            exception = e;
        }

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            data = sb.toString();
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
            exception = e;
        }finally{
            is.close();
        }
        return data;
    }


    @Override
    protected void onPostExecute(String data) {
        if (exception == null && !data.equals("")) {
            this.listener.handlePHPRequestFinished(data);
        } else {
            Toast.makeText((Context) listener, "Error", Toast.LENGTH_LONG).show();
        }
    }
}