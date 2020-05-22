public static String findCorrespondingValue(Map<String, String> map, String key){
    if(map.containsKey(key)){
        return findCorrespondingValue(map, map.get(key));
    }
    return key;
}