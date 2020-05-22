@Data
public class Person {
    private String name;
    private int age;
    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE)
    private Map<String, String> dialog;
}