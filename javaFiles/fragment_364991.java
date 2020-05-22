Map<String, String> test = new HashMap<String, String>() {

    {
        put("1", "1");
        put("2", "2");
    }
};
Map<String, Integer> res = Observable.from(test.entrySet()).toMap(e -> e.getKey(), e -> Integer.parseInt(e.getValue())).toBlocking().first();