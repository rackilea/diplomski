public class MakeQueryTask extends AsyncTask<Void, Void, Void> {

    private Context mContext;

    private String newString;

    public MakeQueryTask(Context context) {
        mContext = context;
    }

    //This runs on a background thread
    @Override
    protected Void doInBackground(Void... params) {


        API Api = new API(keys and tokens);

        //queryAPI() returns string
        setNewString(queryAPI(Api, term1, term2));

        //You should start your activity on main thread. Do it in onPostExecute() which will be invoked after the background thread is done
        //Intent i = new Intent(mContext, AnotherActivity.class);
        //mContext.startActivity(intent);
        return null;
    }

    private void setNewString(String localThreadString){
        newString  = localThreadString;
    }

    //This will run on UI thread
    @Override
    protected void onPostExecute(Void aVoid) {
        Intent intent = new Intent(mContext, AnotherActivity.class);
       mContext.startActivity(intent);
    }
}