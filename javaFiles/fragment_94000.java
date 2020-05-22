public class JSONTask extends AsyncTask<String, String, String> {

    private Context context;

    public JSONTask(Context context){
      this.context = context;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}