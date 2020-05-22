HashSet<List<String>> set = new HashSet<List<String>>();
for (List<String> list : yourMap.values()) {
    if (!set.add(list)) {
        System.out.println("Found a duplicate!");
        break;
    }
}