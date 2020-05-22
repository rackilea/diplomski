public class NotePadFileFromServer extends AsyncTask<Void, Void, String>{

    @Override
    protected String doInBackground(Void... params) {
        try {
            url = new URL(TextFileURL);
            bufferReader = new BufferedReader(new InputStreamReader(url.openStream()));
            TextHolder = bufferReader.readLine();
            bufferReader.close();
            return "Success!";
        } catch (Exception e) {
            return "Fail!";
        }
    }

    @Override
    protected void onPostExecute(String finalTextHolder) {
        Toast.makeText(MainActivity.this, finalTextHolder, Toast.LENGTH_SHORT).show();
        super.onPostExecute(finalTextHolder);
    }

}