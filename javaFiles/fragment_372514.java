public double getEstimation(Hashtable<String, String> params) {
    // not sure if date is in this format
    SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
    Date date = sdt.parse(params.get("Date"));
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(date);

    HashTable<String, String> data = jsonStringToHT(params.get("Data1"));
    //...
}

private HashTable<String, String> jsonStringToHT(String json){
    HashTable<String, String> ht = new HashTable<String, String>();
    JSONObject jObject = new JSONObject(t);
    Iterator<?> keys = jObject.keys();

    while( keys.hasNext() ){
        String key = (String)keys.next();
        String value = jObject.getString(key); 
        ht.put(key, value);

    }
    return ht;
}