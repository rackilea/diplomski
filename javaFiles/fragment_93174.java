private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

@Override
protected String doInBackground(String... urls) {
    String response = "";
    for (String url : urls) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse execute = client.execute(httpGet);
            InputStream content = execute.getEntity().getContent();

            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(content));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                response += s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // since this is the background thread,  we need to return the string reponse so that onPostExecute can update the textview.
    return response
}

@Override
protected void onPostExecute(String result) {
    //  only onPostExecute,onProgressUpdate(Progress...), and onPreExecute can touch modify UI items since this is the UI thread.
    textView.setText(result);
}