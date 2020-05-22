public void addBook(int isbn, String title, int year, String author, double price) {
    books.setIsbn(isbn);
    books.setTitle(title);
    books.setYear(year);
    books.setAuthor(author);
    books.setPrice(price);

    list.add(books);
}