Iterator<?> keys = json.keys(); // json is your `JsonObject`
while( keys.hasNext() ) {
    String key = (String)keys.next();
    Log.e("key",""+key); // This will give you all the keys of your jsonObject, in your case it will be 1ed1,1ed3 etc...
    Log.e("value",""+json.getBoolean(key)); // This will give all the values associated with the key
}