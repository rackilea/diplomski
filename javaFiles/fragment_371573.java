Map<String, Map<String, MyItem>> m = new HashMap<>();

Map<String, MyItem> items = Map.of(
        "Kim", new MyItem("Kim", 25),
        "Lee", new MyItem("Lee", 28)
);

m.put("Samsung", items);

String result = m.entrySet().stream()
        .filter(e -> e.getValue().containsKey(searchKeyWord))
        .findAny()
        .map(Map.Entry::getKey)
        .orElse(null);