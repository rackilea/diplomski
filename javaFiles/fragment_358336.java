private class GetTextOverNetwork extends AsyncTask<String,String,String>{

     protected String doInBackGround()
    {
      // here you get the info off the internet 
    }

    protected void onPostExecute(String result){
     // here you update your UI
    }
}