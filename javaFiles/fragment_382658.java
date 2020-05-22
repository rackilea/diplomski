JSONObject responseDataObj = new JSONObject(responseData);
JSONObject listMainObj = responseDataObj.getJSONObject("listmain");
Iterator keys = listMainObj.keys();
while(keys.hasNext()) {
   // loop to get the dynamic key
   String currentDynamicKey = (String)keys.next();
   //store key in an arraylist which is 16,17,...
   // get the value of the dynamic key
   JSONArray currentDynamicValue = listMainObj.getJSONArray(currentDynamicKey);
   int jsonrraySize = currentDynamicValue.length();
   if(jsonrraySize > 0) {
        for (int i = 0; i < jsonrraySize; i++) {
            JSONObject brandidObj = currentDynamicValue.getJSONObject(i);
            String brandid = brandidObj.getString("brandid");
            System.out.print("Brandid = " + brandid);
            //store brandid in an arraylist
        }                   
    }
}