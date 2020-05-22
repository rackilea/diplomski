Set<Integer> result = null;
for (String key: check_set) {
    if (result == null) {
        result = new HashSet<Integer>(map.get(key));
    }
    else {
        result.retainAll(map.get(key));
    }
}