for (Map<String, Boolean> entry : list) {
    for (String key : entry.keySet()) {
        Boolean value = entry.get(key);
        System.out.println("key = " + key);
        System.out.println("value = " + value);
    }
}