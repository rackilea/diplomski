private void parseJson(JSONObject json){
    String target = json.getString("target");
    boolean success = json.getBoolean("success");
    // If the field is optional, use optXXX
    double rate = json.optDouble("rate", 1d);
    ......

}