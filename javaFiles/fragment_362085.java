Map<String, Integer> msi1 = new LinkedHashMap<>();

msi1.put("hello", 1);
msi1.put("world", 2);
msi1.put("morning", 3);

Iterator<Map.Entry<String, Integer>> it = msi1.entrySet().iterator();

while (it.hasNext()) {
    Map.Entry<String, Integer> entry = it.next();
    if (entry.getKey().equals("world")) {
        it.remove();
    }
    else {
        System.out.println("Found entry: " + entry.getKey() + " -> " + entry.getValue());
    }
}