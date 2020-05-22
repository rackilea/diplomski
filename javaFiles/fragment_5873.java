public String setTest(HttpServletRequest request) throws IOException{
JSONObject j = new JSONObject();
try{
    JsonParser jp = new JsonParser();
    Map m = request.getParameterMap();
    Gson gi = new Gson();
    String stringJson = gi.toJson(m);
    j.put("jsonParse",jp.parse(stringJson));
    j.put("responseStatus", "OK");
}catch(FrameworkException e){
    /*Any code*/
}catch(Throwable t){
    /*Any code*/
}
return j.toJSONString();
}