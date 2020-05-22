public class Cart{
  private Book book;
  ...

  public void setBook (Book book){
      this.book = book;
  }      

  public Cart (int numItems){
     //Initialize the class attributes
     book = new Book();
     itemList = new SaleItem[numItems];
  }

  public void addItem(int code, String title, double price, int quantity, int itemNum){

     if (itemNum == 1){
         System.out.println(book.getAuthor());
     }
  }
}