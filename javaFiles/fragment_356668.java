private HashMap<String, String> putData(String BSSID, int level) {
    HashMap<String, String> item = new HashMap<String, String>();
    item.put("BSSID", BSSID);
    item.put("strength", Integer.toString(level));
    return item;
}