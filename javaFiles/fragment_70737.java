public class ReadJSONTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... url) {
        String response = null;
        String adres = url[0];

        URL url_HTTPRequest = null;
        try {
            url_HTTPRequest = new URL(adres);
            response = transfer(url_HTTPRequest);

        } catch (MalformedURLException e) {
            Log.e("URL ERROR", "problem z url");
        } catch (Exception e) {
        Log.e("URL ERROR", "problem z transferem");
        }               

        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("mylog", "result= " + result);
    }


}