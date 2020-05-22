class UrlRequestTask extends AsyncTask<Void, Void, Void> {
    protected void doInBackground() {
        String sURL = "http://jsonplaceholder.typicode.com/todos";
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) 
            request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            String idcko = rootobj.get("id").getAsString();

            TextView textElement = (TextView) findViewById(R.id.com1);
            textElement.setText(idcko);
    }
}