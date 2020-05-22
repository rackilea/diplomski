Map<List<Integer>, Integer> hm = new HashMap<>();

List<Integer> a = List.of(1, 1, 0, 0);
List<Integer> b = List.of(1, 1, 0, 0);

hm.put(a,1);

if (!hm.containsKey(b)) {
    //key does not exists so, create new one  
    hm.put(b, 1);
}
else {
    //key does exists so, put its value = value + 1
    hm.put(b, hm.get(b)+1); 
}