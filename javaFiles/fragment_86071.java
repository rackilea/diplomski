public class Product {
    private int ProductId;
    private String Description;
    private double Price;

public Product(int pID, String description, double price) {

    ProductId = pID;
    Description = description;
    Price = price;


}

public int getProductID() {
    return this.ProductId;

}

public void setProductID(int input) {   
    this.ProductId = input;
}



public String getDescription() {

    return this.Description;
}

public void setDescription(String DescriptionInput) {
    this.Description  = DescriptionInput;
}




public double getPrice() {
    return this.Price;
}

public void setPrice(double priceInput) {
    this.Price = priceInput;
}

public String toString(){
  return "Product Id: "+ this.ProductId + "Description: " + this.Description + " Price: " + this.Price;
}