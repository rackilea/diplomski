public Book(String title, int pages) {
    this.title = title;
    this.pages = pages;
    (if ArrayBooks.size < 20) {
        ArrayBooks.add(this); // add new Book instance into the list
    }
}