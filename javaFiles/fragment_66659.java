public Map<String, String> getFileMap(List<String> list){
    Map<String, String> fileMap = new LinkedHashMap<String, String>();
    String key = "";
    for(int x = 0; x < list.size(); x++) {
        if((x + 1 ) % 2 != 0) {
            key = list.get(x);
        }else {
            fileMap.put(key, list.get(x));
        }
    }
    return fileMap;
}