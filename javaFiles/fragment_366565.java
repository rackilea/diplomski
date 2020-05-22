@Entity
public class Product {
  @Id @GeneratedValue
  String serialNumber;

  @ElementCollection
  Set<Part> parts = new HashSet<Part>();
}

@Entity
public class Part {
    @Id @GeneratedValue
    int id;

    String partName;
}