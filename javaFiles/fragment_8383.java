public class FetchPop extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        String host = "pop.gmail.com";// I tried google's pop 
        String mailStoreType = "pop3";

        String username = params[0]; //passed in through the execute() method      
        String password = params[1]; //passed in through the execute() method

        //Call method fetch
        fetch(host, mailStoreType, username, password);
        Log.d("mytag", "done!");
        return null;
    }
}