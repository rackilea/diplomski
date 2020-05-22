ISBN isbn = new ISBN("0-201-63361-2");
List<Book> found = new ArrayList<Book>();
for(Book book : books){
    if(book.getIsbn().equals(isbn)){
        found.add(book);
    }
}
books.removeAll(found);