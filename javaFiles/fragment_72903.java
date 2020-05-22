public Boolean updateSingleClient(Map map, String id) {
    StringBuilder updateSet = new StringBuilder();
    for (Object key : map.keySet()) {
        String value = (String) map.get(key);
        updateSet.append(key + "='" + value + "',"); 
    }
    updateSet.deleteCharAt(updateSet.lastIndexOf(","));
    System.out.println(updateSet);
    return false;
}