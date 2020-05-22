Comparator<Integer> cmp = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null) {
            return (o2 == null) ? 0 : -1;
        }
        return o1.compareTo(o2);
    }
};