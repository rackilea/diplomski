String result = "{\"Patient 0\":{\"firstName\":\"admir\",\"lastName\":\"andrade\",\"email\":\"admirmonteiro@live.com\"},\"Patient 1\":{\"firstName\":\"alden\",\"lastName\":\"andrade\",\"email\":\"admirmonteiro@yahoo.com\"}}";

    JSONObject jObject = null;
    try {
        jObject = new JSONObject(result.trim());
        Iterator<?> keys = jObject.keys();

        while(keys.hasNext() ) {
            String key = (String)keys.next();
            if (jObject.get(key) instanceof JSONObject ) {

                String firstName = ((JSONObject) jObject.get(key)).getString("firstName");
                String lastName = ((JSONObject) jObject.get(key)).getString("lastName");
                String email = ((JSONObject) jObject.get(key)).getString("email");
                Log.d("jsondata","Firstname = "+firstName+"\nlastname = "+lastName+"\nemail = "+email);
            }
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }