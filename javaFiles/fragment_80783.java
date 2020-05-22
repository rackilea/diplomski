......
 CreateTopicsResult result = client.createTopics(Arrays.asList(t1, t2, t3));
 result.values().values().stream().forEach(f -> {
        try {
            f.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 });