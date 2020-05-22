String[] arr = { "test", "testing again", "test" };
HashMap<String, Integer> counter = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    if (counter.containsKey(arr[i])) {
        counter.put(arr[i], counter.get(arr[i]) + 1);
    } else {
        counter.put(arr[i], 1);
    }
}
System.out.println("Occurrences:\n");
for (String key : counter.keySet()) {
    System.out.println(key + " x" + counter.get(key));
}