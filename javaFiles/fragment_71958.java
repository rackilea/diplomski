private static Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        int a = weighWord(o1);
        int b = weighWord(o2);
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0;
    }
};