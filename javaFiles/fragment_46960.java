class Book {
    private ArrayList<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return Collection.unmodifiableList(authors);
    }
}

Book book = ...;
List<Author> authors = book.getAuthors();