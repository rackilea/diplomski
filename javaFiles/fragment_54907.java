import lombok.AccessLevel;
 import lombok.Getter;
 import lombok.Setter;

 public class GetterSetterExample {
   @Getter @Setter private int age = 10;
   @Setter(AccessLevel.PROTECTED) private String name;
 }