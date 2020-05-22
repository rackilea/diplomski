Map<String, List<String>> example = new HashMap<>();
public void put(String k, String v){
    if (!example.containsKey(k)){
        example.put(k, new ArrayList<>();
    }
    example.get(k).add(v);
}