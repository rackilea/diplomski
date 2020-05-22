String s = "{ \"min\": { \"week\": \"1\", \"year\": \"2014\" }, \"max\": { \"week\": \"14\", \"year\": \"2017\" } }";
JSONParser parser = new JSONParser();
try {
    JSONObject json = (JSONObject) parser.parse(s);
    System.out.println(json.get("min"));
    // this will output
    //{"week":"1","year":"2014"}
} catch (Exception e){
    e.printStackTrace();
}