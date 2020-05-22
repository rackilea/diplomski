String[][] pairs={ {"foo","bar"}, {"hello","world"} };

Map<String,String> map = new AbstractMap<String, String>() {
    public Set<Map.Entry<String, String>> entrySet() {
        return new AbstractSet<Entry<String, String>>() {
            public Iterator<Map.Entry<String, String>> iterator() {
                return Arrays.stream(pairs)
                    .<Entry<String,String>>map(p -> new SimpleImmutableEntry<>(p[0],p[1]))
                    .iterator();
            }
            public int size() {
                return pairs.length;
            }
        };
    }
};

System.out.println(map.get("foo"));
System.out.println(map.containsKey("hello"));
System.out.println(map.containsValue("world"));
map.forEach((k,v) -> System.out.println(k+" -> "+v));
System.out.println(map);