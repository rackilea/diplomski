public class ProductKey{

  private Long id;
  private string type;
  private string subType;

  private ProductKey(){
  }

  public static ProductKey ofWithId(Long id){
    ProductKey productKey = new ProductKey();
    productKey.id = id;  
    return productKey;
  }
   ...
  // other factory methods
   ...
  // equals and hashcode overriden of course
}