String[] children = ((File) parent).list();
Arrays.sort(children, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        // do your comparison
    }
});