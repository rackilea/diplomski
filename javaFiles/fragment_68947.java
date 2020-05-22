public void getCardData(JSONObject elementObj) {
        //pull out jsonObject (of tags) from element
        try {
            JSONObject tagObj = elementObj.getJSONObject("tags");
        } catch (JSONException e) {
            Log.e(TAG, "getCardData: error creating tag json object");
            e.printStackTrace();
        }

        //assign road name
        try {
            //for each element, get its required tags and get string of value
            roadName = elementObj.getJSONObject("tags").getString("name");
            Log.d(TAG, "responseParse: ROADNAME RETRIEVED: " + roadName);
        } catch (JSONException e) {
            Log.w(TAG, "responseParse: JSON exception occurred: no NAME for road");
            roadName = "NO ROAD NAME AVAILABLE";
        }

        //assign road ID
        try {
            roadId = elementObj.getString("id");
            Log.d(TAG, "responseParse: ID RETRIEVED: " + roadId);
        } catch (JSONException e) {
            Log.w(TAG, "responseParse: JSON exception occurred: no ID for road");
            roadId = "NO ROAD ID AVAILABLE";
        }

        //assign road limit
        try {
            roadLimit = elementObj.getJSONObject("tags").getString("maxspeed");
            Log.d(TAG, "responseParse: SPEED RETRIEVED: " + roadLimit);
        } catch (JSONException e) {
            Log.w(TAG, "responseParse: JSON exception occurred: no SPEED for road");
            roadLimit = "NO ROAD LIMIT AVAILABLE";
        }

        //add element (road) values into array (new card)
        roadArrList.add(new CardRoad(R.drawable.ic_road, roadName, roadId, roadLimit));
    }