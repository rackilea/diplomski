String jString = "{\"a\": 1, \"b\": \"str\"}";
JSONObject jObj = new JSONObject(jString);
Object aObj = jObj.get("a");
if(aObj instanceof Integer){
    System.out.println(aObj);
}