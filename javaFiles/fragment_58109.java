private class myStreamReader extends AsyncTask<String, Void, String> {
    String str = "";
    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL("http://github.com/wasiro/myapp/version.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            str = in.readLine();
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        return "Executed";
    }

    @Override
    protected void onPostExecute(String result) {
        //do something here
         httpStuff.setText(str);
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}