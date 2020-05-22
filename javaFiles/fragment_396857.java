private void print(Map<String, String> map) {
        Enumeration<String> keys = Collections.enumeration(map.keySet());
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            boolean contains = nextElement.contains("Test");
            System.out.println(contains);
        }
    }