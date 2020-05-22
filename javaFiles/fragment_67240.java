public static <T> T findCorrespondingValue(Map<? extends T, ? extends T> map, T key){
    if(map.containsKey(key)){
        return findCorrespondingValue(map, map.get(key));
    }
    return key;
}