class SubmitAsync extends AsyncTask<String, Void, Void>{
    @Override
    protected Void doInBackground(String... params){
        HttpPost postMethod = new HttpPost("http://address-of-script.php");
        postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        response = client.execute(postMethod, responseHandler);
        JSONArray jsonArray  = new JSONArray(response);
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject j = jsonArray.getJSONObject(i);
            String name = String.format("%11s", j.get("name"));
            String score = String.format("%10s", j.get("score"));
            highscores.add(name + score);
        }
    }
}