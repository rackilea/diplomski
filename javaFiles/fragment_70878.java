public class Book {
    public Book() {}
    private Integer book_id, category_id;
    private String isbn, book_title;
    private String author, publisher, location;
    private Double price_after, price_before;
    private Integer discount, stok, status;

        public Book(Integer book_id, Integer category_id, String isbn, String book_title, String author, String publisher, String location,Integer discount, Double price_before, Double price_after, Integer stok, Integer status) {
        this.book_id = book_id;
        this.category_id = category_id;
        this.isbn = isbn;
        this.book_title = book_title;
        this.status = status;
        this.author = author;
        this.publisher = publisher;
        this.location = location;
        this.price_after = price_after;
        this.price_before = price_before;
        this.discount = discount;
        this.setStok(stok);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice_after() {
        return price_after;
    }

    public void setPrice_after(double price_after) {
        this.price_after = price_after;
    }

    public double getPrice_before() {
        return price_before;
    }

    public void setPrice_before(double price_before) {
        this.price_before = price_before;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
}