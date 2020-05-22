Iterator<?> keys = response.keys();
while( keys.hasNext() ) {
    String key = (String)keys.next();
    if ( response.get(key) instanceof JSONObject ) {
        System.out.println(key); // do whatever you want with it
    }
}