@Entity
public class Vendors {
  @Id
  private int vendorId;
  private String vendorName;
  @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @NotEmpty
  private List<Product> products = new ArrayList<>();
}