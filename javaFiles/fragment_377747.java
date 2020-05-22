public static void main(String[] args) {
        List<Test> values = new ArrayList<>();
        Map<String, Test> indices = new HashMap<>();

        addToList(values, indices, new Test("one"));
        addToList(values, indices, new Test("two"));
        addToList(values, indices, new Test("three"));

        System.out.println(indices.keySet().contains("two"));
        System.out.println(indices.keySet().contains("five"));

        removeFromList(values, indices, "two");

        System.out.println(indices.keySet().contains("two"));
    }

    private static void addToList(List<Test> values, Map<String, Test> indices, Test item) {
        values.add(item);
        indices.put(item.val, item);
    }

    private static void removeFromList(List<Test> values, Map<String, Test> indices, String key) {
        Test item = indices.remove(key);
        values.remove(item);
    }