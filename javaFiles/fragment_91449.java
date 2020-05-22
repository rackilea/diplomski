class MyAsyncTask extends AsyncTask<Void, Void, Boolean> {
    String errorMsg;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(Void... v) {
        try{
            jObject = GooglePlacesStuff.getTheJSON(formatedURL);
            myJSONmap = JSONextractor.getJSONHMArrayL(jObject);
            //do stuff
            return true;
        } catch (JSONException e){
            errorMsg="Something wrong in the json";
            return false;
        }

    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            locatePlace(myJSONmap);
            //update layout
        } else {
            //show error
        }


    }
}