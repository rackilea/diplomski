private class GetTask extends AsyncTask<String, Void, IBaseObject> {
    protected IBaseObject doInBackground(String... url) {
        // Get your data.
        // Construct your corresponding object given by specific
        // parameters from your JSON response.
        if (a_parameter_match) {
            return new ObjectOne(some_json_params...);
        } else {
            return new ObjectTwo(some_json_params...);
        }        
    }    

    protected void onPostExecute(IBaseObject object) {
        object.getError(); // Or whatever you need here.
    }
}