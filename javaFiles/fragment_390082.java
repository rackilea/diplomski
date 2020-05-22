public class Product {
public Product(){

}
    private String product;
    private Double price;

public Product(String json ){
    Gson gson=new Gson();
    try{
        Product product =gson.fromJson(json, Product.class);
        if (product!=null){
            System.out.println("Name: " +product.getProduct());
        }
    }catch (Exception e){
        System.out.println("failed: " +e.getMessage());
    }
}

    public String getProduct() {
        return product;
    }

    public Double getPrice() {
        return price;
    }
 }