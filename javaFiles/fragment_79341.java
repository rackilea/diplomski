String address = "";
JSONObject response = new JSONObject(inputJSONString);
JSONArray userDataArray = response.optJSONArray("Usedata");
if (userDataArray != null && userDataArray.length() > 0) {
    JSONObject dataObject = userDataArray.optJSONObject(0);
    if (dataObject != null && dataObject.has("address")) {
            address = dataObject.getString("address");
    }
}