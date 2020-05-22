@Entity
@SecondaryTables({ @SecondaryTable(name = "vendors"), @SecondaryTable(name = "categories") })
public class Product {
  @Id
  private int productId;
  private String productName;
  private BigDecimal productPrice;
  private String productVendorName;
  private String productCategoryName;
  @Column(table = "categories")
  private Integer categoryId;
  @Column(table = "categories")
  private String categoryName;
  @Column(table = "vendors")
  private int vendorId;
  @Column(table = "vendors")
  private String vendorName;
}