@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
  ...

  @ToString.Exclude
  private Categorie categorie;

  ...
}

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
  ...

  @ToString.Exclude
  private Collection<Product> products=new ArrayList<>();

  ...
}