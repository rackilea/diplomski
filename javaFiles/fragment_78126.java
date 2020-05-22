private int stock_max;
Book[] stock;
private int book_counter;

public Bookshop(int size){
    this.stock_max = size;
    this.stock = new Book[stock_max];
}