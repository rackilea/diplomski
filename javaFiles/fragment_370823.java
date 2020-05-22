class MyAsync extends AsyncTask<String, Integer, ArrayList<HashMap<String, String>>> {
    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(String... urls) {
        ArrayList<HashMap<String, String>> listOfHM = null;
        if (urls != null && urls.length > 0 && urls[0] != null) {
            String formattedUrl = urls[0];
            try {
                JSONObject jobject = GooglePlacesStuff.getTheJSON(formattedURL);
                listOfHM = JSONextractor.getJSONHMArrayL(jobject);
            } catch (Exception e) {
                // log error
            }
        }
        return listOfHM;
    }

    @Override
    protected void onPostExecute(ArrayList<HashMap<String, String>> listOfHM){
        if (listOfHM != null && !listOfHM.isEmpty()) {
            // iterate through and get the names of the nearby restaurants from the array of hasmap strings
            for(int i =0 ; i < listOfHM.size() ;i++ ){
                String currentName = listOfHM.get(i).get(JSONextractor.TAG_NAME);
                listOfValues.add(currentName);
            }
            // do your adapter stuff
        }
        gps.stopUsingGPS();  // stop using the gps after i get the list to save on resource
    }
}