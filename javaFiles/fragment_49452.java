//Solution from Melike Ttkn from the mentioned link

public HashMap<String, Integer> mergeAndAdd(ArrayList<HashMap<String, Integer>> maplist) {
    HashMap<String, Integer> result = new HashMap<>();
    for (HashMap<String, Integer> map : maplist) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer current = result.get(key);
            result.put(key, current == null ? entry.getValue() : entry.getValue() + current);
        }
    }
    return result;
}