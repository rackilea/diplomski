public class Booklist {

private Map<Long, Book> books = Databaseclasss.getBooks();

public Booklist() {
    books.put(1L, new Book("I","you",1));
    books.put(2L, new Book("me","me",2));
}

public List<Book> getAllBooks(){
    return new ArrayList<Book>(books.values());
}

public Book getBook(Long id) {
    return books.get(id);
}

public Book addBook(Book book) {
    book.setid(books.size()+1);
    books.put(book.getId().longValue(), book);
    return book;
}

public Book removeBook(Long id) {
    return books.remove(id);
}
}