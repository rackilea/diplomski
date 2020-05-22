enum BookType { ENCYCLOPEDIA, NOVEL, AUTOBIOGRAPHY, etc... };

class Book {
    ...
    private BookType bookType;

    public Book(int id, String t, String aName, String aSurname, int d, BookType bookType) {
        ...
    }
}