public class Book {
    private String isbn;
    private double price;
    private int copies;

    public Book(String isbnNum, double priceOfBook, int copiesInStock) { // Constructor?
        isbn = isbnNum;
        price = priceOfBook;
        copies = copiesInStock;
    }

    public String getISBN() {
        return this.isbn;
    }

    public double getPrice() {
        return this.price;
    }

    public int getCopies() {
        return this.copies;
    }

    public void setISBN(String value) {
        this.isbn = value;
    }

    public void setPrice(double value) {
        this.price = value;
    }

    public void setCopies(int value) {
        this.copies = value;
    }
}