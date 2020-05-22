HashMap<String, ArrayList<Number>> map = new HashMap<String, ArrayList<Number>>();
map.put("A", new ArrayList<Number>());
map.put("B", new ArrayList<Number>());
map.put("C", new ArrayList<Number>());
for (int i = 1; i < 100; i++) {
    if (i % 15 == 0) {
        map.get("A").add(i);
    } else if (i % 5 == 0) {
        map.get("B").add(i);
        System.out.println("B=" + i);
    } else if (i % 3 == 0) {
        map.get("C").add(i);
    }
}
for (Entry<String, ArrayList<Number>> entry : map.entrySet()) {
    System.out.print(entry.getKey() + "=");
    String strResults = Arrays.toString(entry.getValue().toArray());
    System.out.print(strResults.substring(1, strResults.length() - 1));
    System.out.println();
}