private void readYourJSON(){
    String jsonString = "[{\"objMobileCapabilityId\":2,\"objMobileCapabilityValue\":2,\"objMobileCapabilityDe\":\"Test Rick\",\"objMobileDisplayOrder\":2},{\"objMobileCapabilityId\":1,\"objMobileCapability\":1,\"objMobileCapabilityDesc\":\"Receive RM (Add\\/Edit\\/Delete)\",\"objMobileDisplayOrder\":1}]";
    ArrayList<UserLogin> users = new ArrayList<>();
    try {
        JSONArray array = new JSONArray(jsonString);
        Log.e("Size: ", String.valueOf(array.length()));
        for(int i = 0; i < array.length(); i++){
            JSONObject currentObject = (JSONObject) array.get(i);
            users.add(new UserLogin(currentObject.getInt("objMobileCapabilityId"),
                    currentObject.getInt("objMobileCapabilityValue"),
                    currentObject.getString("objMobileCapabilityDe"),
                    currentObject.getInt("objMobileDisplayOrder")
                    ));
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
    txt.setText(users.get(0).getObjMobileCapabilityDesc());
}