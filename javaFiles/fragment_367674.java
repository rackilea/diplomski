void fillArrayListOfBooks()
{
    for (int i = 0; i < 10; i++) {
        dbooks.add(new Book("Book" + i, "Author" + i, "isbn" + i));
    }
}