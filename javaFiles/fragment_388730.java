Collections.sort(list, new Comparator<SortingTest>() {
    @Override
    public int compare(SortingTest o1, SortingTest o2) {
        int result = o1.name.compareTo(o2.name);
        if (result == 0) {
            result = o1.date.compareTo(o2.date);
        } else {
            result = -result;
        }
        return result;
    }
});