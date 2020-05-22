private void storeRecord(String Id, String Name, String Phone, String Address) {
    final SharedPreferences prefs = getMySharedPreferences();
    SharedPreferences.Editor editor = prefs.edit();
    String data = TextUtils.join(",", new String[]{Id, Name, Phone, Address});
    editor.putString("record_" + Id, data);
    editor.commit();
}

private String[] getRecord(String Id, bool usePrefix) {
    final SharedPreferences prefs = getMySharedPreferences();
    String data = (String) prefs.getAll().get((usePrefix ? "record_" + Id : Id));
    return TextUtils.split(data, ",");
}

private ArrayList<String[]> getAllRecords() {
    final SharedPreferences prefs = getMySharedPreferences();
    Map<String,?> all = prefs.getAll();
    Iterator it = all.entrySet().iterator();
    ArrayList<String[]> result = new ArrayList<String[]>();
    while(it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
        if (pairs.getKey().toString().startsWith("record_")) {
            result.add(getRecord(pairs.getKey().toString(), false));
        }
    }
    return result;
}