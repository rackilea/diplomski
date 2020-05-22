public class MyTask extends AsyncTask<String, Void, String> {
    MyTask() {}
    @Override
    protected Boolean doInBackground(String... params) {

        try {
           // REST CALL
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        if (success) {
            // handle post execute
        }
    }

    @Override
    protected void onCancelled() {

    }
}