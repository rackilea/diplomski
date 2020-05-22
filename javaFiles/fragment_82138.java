public class Fetcher extends AsyncTask<String, Void, JsonReader> {

    @Override
    protected JsonReader doInBackground(String... urlString) {

    JsonReader jReader = null;
        try {
            URL url = new URL(urlString[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            jReader = new JsonReader(reader);

        } catch(MalformedURLException malformedEx) {
            Log.e("malformed url: ", "here are the details: ", malformedEx);
        } catch(IOException ioEx) {
            Log.e("IO problem: ", "here are the details: ", ioEx);
        } catch(Exception generalEx) {
            Log.e("an exception we did not expect: ", "here are the details: ", generalEx);
        } finally {
           // CLOSE YOUR STREAMS
        }

        return jReader;

    }
}