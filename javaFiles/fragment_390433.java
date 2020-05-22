Iterator<?> keys = jsonObject.getJSONObject("result").getJSONObject("cov_details").keys();

while( keys.hasNext() ) {
   String key = (String)keys.next();
   String value= jObject.get(key);
   //do whatever you want to do
}