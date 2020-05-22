List<String> items = new ArrayList<>();
items.add("Bread");
items.add("Cheese");
items.add("Coke");
items.add("Coke");
items.add("Cheese");
items.add("Crisps");

Map<String, Integer> counts = new HashMap<>();
for (String item : items) {
    Integer count = counts.get(item);
    if (count == null) {
        count = new Integer(0);
    }
    count = count + 1;
    counts.put(item, count);
}

System.out.println(counts);