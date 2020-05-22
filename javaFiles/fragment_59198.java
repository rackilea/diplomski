synchronized(this.books) {
   List<Book> copyOfBooks = new ArrayList<Book>(this.books)
}
for(Book book : copyOfBooks) {
   System.out.println(book);
}