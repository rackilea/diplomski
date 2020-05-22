class Book {
    private String title;

    // Empty Constructor
    public Book() {

    }

    // Overloaded Constructor which accepts a
    // Title string argument.
    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}