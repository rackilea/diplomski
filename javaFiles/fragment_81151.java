@Entity
public class Category {
  @Id
  private Integer categoryId;
  private String categoryName;
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @NotEmpty
  private List<Product> products = new ArrayList<>();
}