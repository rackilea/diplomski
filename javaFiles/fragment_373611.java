Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
// + some for loop here
Set<Integer> ints = map.get(type);
if(ints == null) {
    ints = new HashSet<>();
    map.put(type, ints);
}
ints.add(intToAdd);