public boolean exits(String value) {
    Map<String, ?> allEntries = prefA.getAll();
    for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
        Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        if ("yourvalue".equals(entry.getValue().toString()) {
            // the value exits; 
            return true;
        }
    } 
    return false;
}