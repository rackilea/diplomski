//method 1
String myJson = " {errorCode:"+errorCode+"}";
ErrorCode = new JSONObject(myJson);

//method 2
ErrorCode = new JSONObject();
ErrorCode.put("errorCode", errorCode);// jsonObject.put(String key,Object value);