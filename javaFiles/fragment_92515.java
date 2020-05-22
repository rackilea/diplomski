@Entity
public class Product {
  // ...

  @ElementCollection
  @Enumerated
  private Set<MyEnum> enums;

}