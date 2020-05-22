new Comparator<Map.Entry<String, Integer>>() {
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        //sorting in descending order
        return o2.getValue().compareTo(o1.getValue());
    }
}