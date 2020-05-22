private void parseJson() {
    try {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONObject jObj = obj.getJSONObject("data");
        Iterator iter = jObj.keys()
        while(iter.hasNext()) {
            String key = (String) iter.next();
            JSONObject jObj1 = jObj.getJSONObject(key);
            System.out.println("Index==> "+ key);
            System.out.println("OutletName==> "+jObj1.getString("OutletName"));
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
}