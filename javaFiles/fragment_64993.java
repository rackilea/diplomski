Collections.sort(list, new Comparator<Map<String, String>>() {
    public int compare(Map<String, String> o1, Map<String, String> o2) {
        if (o1.containsKey("songTitle") && o2.containsKey("songTitle")) {
            return o1.get("songTitle").compareTo(o2.get("songTitle"));
        }
        return 0;
    }
});