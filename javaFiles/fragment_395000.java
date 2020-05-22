public ArrayList<Book> findBooksWrittenBy(ArrayList<Book> bookList, String author) {
    ArrayList<Book> booksByAuthor = new ArrayList<Book>();
    for(int i = 0; i < bookList.size(); i++) {
        Book book = bookList.get(i);
        String author1 = book.getAuthor();
        if(author1.equalsIgnoreCase(author)) {
            booksByAuthor.add(book);
        }
    }
    if(booksByAuthor.size() > 0) {
        return booksByAuthor;
    }else {
       return null;
    }
}