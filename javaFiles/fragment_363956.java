Collections.sort(items, new Comparator<someclass>() {
    @Override
    public int compare(someclass item1, someclass item2) {
        return item1.Name.compareTo(item2.Name);
    }
});