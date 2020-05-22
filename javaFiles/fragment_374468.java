List<Book> al = new ArrayList<>();
Iterator<Book> iter = books.iterator();
while (iter.hasNext()) {
    Book book = iter.next();
    if (authorName.equalsIgnoreCase(book.getAuthor())) {
        al.add(book);
    }
}
return al;