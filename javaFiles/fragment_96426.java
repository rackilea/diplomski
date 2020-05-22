List<String> singers = new ArrayList<String>(map.keySet());
Collections.sort(singers, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        Integer popularity1 = map.get(s1);
        Integer popularity2 = map.get(s2);
        return popularity1.compareTo(popularity2);
    }
});