private class LongOperation extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        InternetHandler ih = new InternetHandler();
        String[] values = ih.getList();
    }

    @Override
    protected void onPostExecute(String result) {
        //Liste konvertieren
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
            R.layout.listview_item, //Genutztes Layout
            values); //Genutzter Array

        //listView einstellen
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}