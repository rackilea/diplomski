SortedMap<String, Integer> m = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int s2length = s2.split(" ").length;
            int s1length = s1.split(" ").length;
            return s2length>s1length?-1:s2length==s1length && s2.equals(s1)?0:1;
        }
    });

    m.put("mango tree", 5);
    m.put("you have to check this out too", 1);
    m.put("apple", 1);
    m.put("apple", 5);
    m.put("you have to check this out", 1);
    m.put("check this out", 1);
    m.put("Bought new watch", 2);
    m.put("check this out too", 1);

    System.out.println(m);