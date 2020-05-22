public Book searchTitle(String title) {
    for (Book book : library) {
        if (book.getTitle().equals(title)) {
            return book;
        }
    }
    return null;
}