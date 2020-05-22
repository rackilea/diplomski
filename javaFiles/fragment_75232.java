try {
     JSONArray jsonArray = new JSONArray(json);
     JSONObject obj = jsonArray.getJSONObject(0); //0 for just retrieving first object you can loop it
     String myVehicleID = obj.getString("vehicleId"); //To retrieve vehicleId
     //Similarly do it for others as well
    } catch (JSONException e) {
      e.printStackTrace();
    }