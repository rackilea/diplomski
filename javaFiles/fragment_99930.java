@XmlRootElement
@XmlType(propOrder = {"brand", "description"})
public class Car {
  private String registration;
  private String brand;
  private String description;

  @XmlAttribute
  public String getRegistration() {
      return registration;
  }

  public String getBrand() {
      return brand;
  }

  public String getDescription() {
      return description;
  }