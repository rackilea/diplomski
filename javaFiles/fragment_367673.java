void fillArrayListOfBooks()
{
    addBooksNames();
    addBooksAuthor();
    addBooksIsbn();
    for (int i = 0; i < 10; i++) {
        dbooks.add(new Book(booksNames.get(i), booksAuthors.get(i), booksIsbn.get(i)));
    }
}