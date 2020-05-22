public class BackgroundTask extends AsyncTask<String,Void,String>{

    @Override
    protected String doInBackground(String... params) {
    String json_url="http://192.168.56.1/dan/db/getjson.php?election_id=" + params[0];

      //perform network operation and return response
      return response;
    }

    @Override
    protected void onPostExecute(String res){
      //Batman Rocks
    }
}