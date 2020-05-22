Comparator<String> c = new Comparator<String>() {
    @Override
    public int compare(final String o1, final String o2) {
        return -o1.substring(o1.indexOf("#") + 1).compareTo(o2.substring(o2.indexOf("#") + 1));
    }
};