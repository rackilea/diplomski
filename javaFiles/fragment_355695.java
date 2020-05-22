public class RetreiveFeedTask extends AsyncTask<Context, Void, String[]> {
    String[] q;

    @Override
    protected String[] doInBackground(Context... params) {
        //computation
        return result; // result is of type String[]
    }

    protected void onPostExecute(String[] result) {
        // do something with result ...
        er=q;
        gff=true;
    }
}