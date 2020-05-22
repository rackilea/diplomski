public static void main(String[] args) {
        Map<String, Object> Types = new LinkedHashMap<String, Object>();
        Types.put("\"String.class\"", new Parent());

        for (Map.Entry entry : Types.entrySet()) {
            System.out.println(entry.getKey());
        }
    }