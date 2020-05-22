public class ProductAction extends ActionSupport {
  private Integer n;
  private Collection<Product> products;

  @Override
  public String execute() throws Exception {
    // you may want to add logic for when no products or null is returned.
    this.products = productService.getProducts( n );
    return SUCCESS;
  }

  // this method allows 'n' to be visible to the view technology if needed.
  public Integer getN() {
    return n; 
  }

  // this method allows the request to set 'n'
  public void setN(Integer n) {
    this.n = n;
  }

  // makes the collection of products visible in the view technology.
  public Collection<Product> getProducts() {
    return products;
  }      
}