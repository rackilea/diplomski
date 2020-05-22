Supplier<SortedMap<String, String>> supplier = new Supplier<SortedMap<String, String>>() {

        @Override
        public SortedMap<String, String> get() {
            return new TreeMap<String, String>((a, b) -> a.compareTo(b));
        }
    };

    // [{a.p=aa}, {a.r=aaaa}, {a.q=aaa}, {a.s=aaaaa}, {b.p=bb}, {b.r=bbbb}, {c.r=cccc}, {c.q=ccc}, {d.s=ddddd}, {d.p=ddd}]
    Map<String, String> map = new HashMap<String, String>();
    map.put("a.p", "aa");
    map.put("a.r", "aaaa");
    map.put("a.q", "aaa");
    map.put("a.s", "aaaaa");
    map.put("b.p", "bb");
    map.put("b.r", "bbbb");
    map.put("c.r", "cccc");
    map.put("c.q", "ccc");
    map.put("d.s", "ddddd");
    map.put("d.p", "aaaa");

    Map<String, SortedMap<String, String>> collect = map
            .entrySet()
            .stream()
            .collect(
                    Collectors.groupingBy((k -> k.getKey().substring(0, k.getKey().indexOf('.'))),
                            Collectors.toMap(k -> ((Entry<String, String>) k).getKey(), k -> ((Entry<String, String>) k).getValue(), (a, b) -> a, supplier)));