Iterator<?> keys = jsonObject.keys();

/* Iterate over all the elements and sub-elements and assign as 
 * needed. Based on the type you can concert each item to a JSONObject or 
 * JSONArray, etc.
 */
while (keys.hasNext()) {
    String key = (String) keys.next();

    System.out.println(key + "\t" + jsonObject.get(key) + "\t" + jsonObject.get(key).getClass());
}