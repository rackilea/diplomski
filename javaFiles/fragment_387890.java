Map<String, Integer> opPriority = new HashMap<String, Integer>() {
    {
        put("-", 1);
        put("+", 2);
        put("^", 3);
        put("/", 4);
        put("*", 5);
        put("(", 1);
        put(")", 1);
    }
};