(...)
        List<Test> values = new ArrayList<>();
        values.add(new Test("one"));
        values.add(new Test("two"));
        values.add(new Test("three"));

        Map<String, Test> indices = new HashMap<>();
        for (Test v : values) {
            indices.put(v.val, v);
        }

        System.out.println(indices.containsKey("two"));
        System.out.println(indices.containsKey("five"));
        // or...
        System.out.println(indices.keySet().contains("two"));
        System.out.println(indices.keySet().contains("five"));
        (...)