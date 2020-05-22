@Test
public void countOccurrences() {
    LinkedList<String> strings = new LinkedList<String>(){{
        add("Fred");
        add("Fred");
        add("Joe");
        add("Mary");
        add("Mary");
        add("Mary");
    }};

    Map<String,Integer> count = count(strings,new HashMap<String,Integer>());
    System.out.println("count = " + count);
}

private Map<String, Integer> count(List<String> strings, Map<String, Integer> runningCount) {
    if(strings.isEmpty()) {
        return runningCount;
    }
    String current = strings.get(0);
    int startingSize = strings.size();
    while(strings.contains(current)) {
        strings.remove(current);
    }
    runningCount.put(current, startingSize - strings.size());
    return count(strings,runningCount);
}