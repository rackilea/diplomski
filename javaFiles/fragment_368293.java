class FontAlphabetizer
implements Comparator<Font> {
    @Override
    public int compare(Font font1, Font font2) {
        return font1.getName().compareTo(font2.getName());
    }
}