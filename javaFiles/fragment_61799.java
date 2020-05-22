try { 
            JsonParser jParser = new JsonParser();
            JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);
            JSONObject onlineJsonObj = json.getJSONObject("online");
            JSONObject menJsonObj = online.getJSONObject("men");
            JSONObject clothesJsonObj= menJsonObj.getJSONObject("clothes");
            JSONObject jeanJsonObj= clothesJsonObj.getJSONObject("jean");

                lastname = clothesJsonObj.getString("cost");
                username = clothesJsonObj.getString("size");
                Log.e("Hello", "firstname: " + firstname + ", lastname: "
                        + lastname + ", username: " + username + "star:"
                        + username1);
            } 
        } catch (JSONException e) {
            e.printStackTrace();
        } 
        return null; 
    }