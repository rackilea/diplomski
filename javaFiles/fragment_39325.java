class LoadAllGamet extends AsyncTask<String, Void, HashMap<String,String>> {
    protected HashMap<String,String> doInBackground(String ... args) {
        HashMap<String,String> finaloutcomes = new HashMap<>(),
        HashMap<Integer, HashMap<String,String>> allbetsmap = new HashMap<>();

        HttpClient client = new DefaultHttpClient();
        ...
        Log.d("SIZE",Integer.toString(allbetsmap.size()));
        if (allbetsmap.size() == passtocheck.size()) {
          ...
        }
        Log.d("Vital",finaloutcomes.toString());
        return finaloutcomes;
    }
}