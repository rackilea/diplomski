public interface DTO {
    find(Object args)
}
public class ConcreteDTO1 implements DTO {
   ...
}
public class ConcreteDTO2 implements DTO {
   ...
}
public enum DTOType {

  CONCRETE_DTO1(new ConcreteDTO1(someArgs)),
  CONCRETE_DTO2(new ConcreteDTO2(someOtherArgs))

  private DTO dto;
  public DTOType(DTO dto) {
    this.dto = dto;
  }

  public DTO dto() {
    return dto;
  }
}