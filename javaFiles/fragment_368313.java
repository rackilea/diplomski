Book book = null;
while (fileRead != null) {
    if (fileRead.startsWith("#index"))
    {
        if (book != null) // we're finished with the current book
        {
            books.add(book);
        }
        book = new Book();
    }
    else if (fileRead.startsWith("#"))
    {
        CODE_TO_SETTER.get(fileRead.charAt(1)).accept(book, fileRead.substring(3));
    }
}