public class DataTask extends AsyncTask<Void, Void, Integer> {

    Context context;
    DataTask(Context context) {
        this.context = context; // <-- you already have a context, you don't need to call getApplicationContext();       
    }
    @Override
    protected Integer doInBackground(Void... params) {
        doSomeWork();
        doSomeOtherWork();
        doYetSomeMoreWork();
        //...
    }

    @Override
    protected void onPostExecute(Integer result) {
        doSomethingWithThe(result);
    }
}