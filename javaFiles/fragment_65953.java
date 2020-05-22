private class tmpCourseOfferingTask extends AsyncTask<String,Void,JSONObject> {

    public tmpCourseOfferingTask(){
        super();
    }
    @Override
    protected void onPreExecute(){

    super.onPreExecute();

    progressBar.setVisibility(View.VISIBLE);

    }
    @Override
    protected JSONObject doInBackground(String...params){

      try{
      SystemClock.sleep(timeInMills);
      }catch(Exception ignored){
      }finally{
        return null;
      }
   }

    @Override
    protected void onPostExecute(JSONObject json) {
       progressBar.setVisibility(View.GONE);
    }
 }