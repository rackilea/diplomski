public void deleteBook(String isbn){
    books.stream()
         .filter((b) -> (b.getISBNNumber().equals(isbn)))
         .max(Comparator.comparingInt(Book::getCopyNumber))
         .ifPresent(book->books.remove(book));
}