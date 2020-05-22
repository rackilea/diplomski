public String[] toArray(ArrayList<HashMap<String, String>> list){
    String[] strArray = new String[list.size() * 2];
    int i = 0;
    for (HashMap<String, String> map : list) {
        strArray[i++] = map.get("Lat");
        strArray[i++] = map.get("Long");
    }
    return strArray;
}