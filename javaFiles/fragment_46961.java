class Book {
    private HashSet<Author> authors = new HashSet<>();

    public List<Author> getAuthors() {
        return Collection.unmodifiableList(authors); // ERROR - authors not a list
    }
}