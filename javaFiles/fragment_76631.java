HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
int index = 0;
for (String n: name) {
    if (!map.containsKey(n)) {
        map.put(n, new ArrayList<Integer>());
    }
    map.get(n).add(index);
    index++;
}