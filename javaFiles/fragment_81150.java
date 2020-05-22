@Entity
public class Product {
  @Id
  private int productId;
  private String productName;
  private BigDecimal productPrice;
  private String productVendorName;
  private String productCategoryName;
  @ManyToOne
  @JoinColumn(name = "productCategoryId")
  private Category category;
  @ManyToOne
  @JoinColumn(name = "productVendorId")
  private Vendors vendor;
}