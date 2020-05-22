ArrayList<String> strs = ...;

HashMap<String, Integer> counter = new HashMap<String, Integer>();

for(String s : strs) {
    counter.put(s, counter.get(s) == null ? 1 : counter.get(s) + 1);
}

for(String s : counter.keySet()) {
    System.out.println(s + " (" + counter.get(s) + ")");
}