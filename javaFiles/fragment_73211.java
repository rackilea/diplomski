for (int i = 0; i < jArray.length(); i++) {
        JSONObject jObj = jArray.getJSONObject(i);
        System.out.println(i + " id : " + jObj.getInt("id"));
        System.out.println(i + " att1 : " + jObj.getDouble("att1"));
        System.out.println(i + " att2 : " + jObj.getBoolean("att2"));
}