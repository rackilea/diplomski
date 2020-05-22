class GetDealsByNameDescAdd extends AsyncTask<Void, Void, ArrayList<ListItems>> { 
     private final String URL_STRING = url;
    HttpClient httpclient = new DefaultHttpClient();
     HttpGet httpget = new HttpGet(URL_STRING);
    ArrayList<ListItems> itemsArray;
    String jsonData = null;

    @Override 
     protected ArrayList<ListItems> doInBackground(Void... params){
     try {
                HttpResponse response = httpclient.execute(httpget);
                jsonData =  EntityUtils.toString(response.getEntity());
                Log.d(TAG, String.format("JSON:", jsonData));

            } catch (IOException e) {
                e.printStackTrace();
            }

    itemsArray = new ArrayList<ListItems>();
            JSONObject object = null;
            try {
                object = new JSONObject(jsonData);
                JSONArray jArray  = object.getJSONArray("DATA");

                for(int i = 0; i < jArray.length(); i++){
                    JSONObject jObj = jArray.getJSONObject(i);

                    ListItems item=new ListItems();

                    //String Id = jObj.getString("id"); //replce this with following code
                    item.setId(jObj.getString("id"));

                    //String Name = jObj.getString("name");  //replce this with following code
                    item.setName(jObj.getString("name"));

                    //String Description = jObj.getString("description");   //replce this with following code
                    item.setDescription(jObj.getString("description"));

                    itemsArray.add(items);

                }
            } catch (JSONException e) {
                e.printStackTrace();
                //if there is an exception in parsing json then it returns null
                return null;
            }


            return itemsArray;
    }
    public void onPostExecute(ArrayList<ListItems> items){
        if(items!=null){
            //here you will receive valid set of data 
            //and you can add it to your adapter
        }else{
            //this part will execute, If we are having JSON exception
            // so we need to check the JSON response 
            //and here we should handle this NPE

            //show toast that we are receiving BAD JSON response
        }
    }
}