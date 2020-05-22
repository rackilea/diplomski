JSONParser jParser = new JSONParser();

    // getting JSON string from URL
    String jsonString = jParser.getJSONFromUrl(url).tostring();

    JSONArray json= new JSONArray(jsonString);



    try {

        // looping through All Contacts
            for(int i = 0; i < json.length(); i++){
              JSONObject contacts = json.getJSONObject(i);

                JSONObject user = contacts.getJSONObject("user");

                String imageUrl = user.getString("profile_image_url");
                String screenName = user.getString("Screen_name");

            }
        }catch(Exception e)
   {
   }