public class dbwork extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        String webUrl = params[0];
        // TODO Auto-generated method stub
        StringBuffer strbuffer=new StringBuffer("");
        // ...