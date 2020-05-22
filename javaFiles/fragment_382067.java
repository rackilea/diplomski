Collections.sort(list, new Comparator<String>() {
    public int compare(String o1, String o2) {
        Integer i1 = Integer.parseInt(o1);
        Integer i2 = Integer.parseInt(o2);
        return (i1 > i2 ? -1 : (i1 == i2 ? 0 : 1));
    }
});