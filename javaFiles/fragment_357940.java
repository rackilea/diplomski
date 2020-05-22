public JSONObject addPlace() throws Exception {

try {
       Log.v(LOG_KEY,"Adding Place...");
        String nameAdd = "NAME";  // Enter Place Name
        String typeAdd = "TYPE"; //Enter Place Type
        double lat = 00.0000; //Enter Place Latitude
        double lng = -00.00000; //Enter Place Longitude


       HttpPost post = new HttpPost(PLACE_ADD_URL);
       String postBody = 
               "{"+
                       "\"location\": {" +
                        "\"lat\": " + lat + "," +
                        "\"lng\": " + lng +
                       "}," + 
                       "\"accuracy\":50.0," +
                       "\"name\": \"" + nameAdd + "\"," +
                       "\"types\": [\"" + typeAdd + "\"]," +
                       "\"language\": \"en\" " +

                  "}";
       StringEntity se = new StringEntity(postBody, HTTP.UTF_8);
       post.setEntity(se);
       ResponseHandler<String> responseHandler=new BasicResponseHandler();
       String responseBody = new DefaultHttpClient().execute(post, responseHandler);
       JSONObject response = new JSONObject (responseBody);
       Log.v(LOG_KEY, "Request URL= " + PLACE_ADD_URL);


       return response;

    } catch (HttpResponseException e) {
        Log.v(LOG_KEY, e.getMessage());
        throw e;
    }

    catch (IOException e) {
        // TODO: handle exception
        throw e;
    }
}