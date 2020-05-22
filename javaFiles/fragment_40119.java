class AsyncTest extends AsyncTask<Void,Void,Void>
{
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        try {
            URL url = new URL("http://currency-api.appspot.com/api/USD/EUR.json?key=KEY");
            URLConnection connect = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuilder jsonObject = new StringBuilder();
            String line = "";
            while ((line = in.readLine()) != null)
                jsonObject.append( line );
            in.close();
            Toast.makeText(getApplicationContext(), jsonObject.toString(), Toast.LENGTH_LONG).show();
            JSONObject json = new JSONObject(jsonObject.toString());
            ///// Parse the Json object right here using getString

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(Void result)
    {
        super.onPostExecute(result);;
    }

}