List<Integer> current = multiMap.get(key);
if (current == null) {
    current = new ArrayList<Integer>();
    multiMap.put(key, current);
}
current.add(val);