try {
        JSONObject jsonObject = new JSONObject(response);// here response is your json string

        String id = jsonObject.getString("id");
        /**
         * Same way you can get other string value
         */ 
        JSONObject obj =  jsonObject.getJSONObject("fields");

        JSONArray array2 = obj.getJSONArray("Feedback");

        for (int i = 0; i < array2.length(); i++) {
            JSONObject jsonObject2 = array2.getJSONObject(i);
            ///do something here    
        }   

} catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}