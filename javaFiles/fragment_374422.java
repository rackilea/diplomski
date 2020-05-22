Map<String, Integer> mp = new TreeMap<>(new Comparator<String>(){
    @Override
    public int compare(String key1, String key2) {
               //parse only text after first letter
        int k1 = Integer.parseInt(key1.substring(1));
        int k2 = Integer.parseInt(key2.substring(1));
        return Integer.compare(k1, k2);
    }
});