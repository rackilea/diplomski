public static Book create(final String title, final int pages) {
    if (ArrayBooks.size() < 20) {
        final Book instance = new Book(title, pages);
        ArrayBooks.add(instance);
        return instance;
    }
    return null;
}

private Book(String title, int pages) { // "hide" the constructor, so the user can't use this instead of the factory
    this.title = title;
    this.pages = pages;
}