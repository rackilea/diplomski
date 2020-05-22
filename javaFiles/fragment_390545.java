// Now sort by year instead of name (default).
Collections.sort(list, new Comparator<Music>() {
    public int compare(Music one, Music two) {
        return one.getYear().compareTo(two.getYear());
    }
});