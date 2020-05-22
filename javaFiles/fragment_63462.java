class MyComparator implements Comparator<String> {

    Map<String, Integer> otherMap;

    public MyComparator(Map<String, Integer> otherMap) {
        this.otherMap = otherMap;
    }

    @Override
    public int compare(String o1, String o2) {
        int primary = otherMap.get(o1).compareTo(otherMap.get(o2));
        if (primary != 0)
            return primary;
        // Fall back on comparing the string keys to ensure consistent results
        return o1.compareTo(o2);
    }
}