HashMap<String,Integer> players= new HashMap<String,Integer>();
    players.put("as", 10);
    players.put("a", 12);
    players.put("s", 13);
    players.put("asa", 15);
    players.put("asaasd", 256);
    players.put("asasda", 15);
    players.put("asaws", 5);
    System.out.println(Collections.max(players.entrySet(),new Comparator<Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }));