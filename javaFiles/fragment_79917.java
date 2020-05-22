@Data
public class Person {

    @NotEmpty(groups = CustomPersonGroup.class)
    @Size(min = 10)
    @Pattern(regexp = "[0-9]*")
    private String name;
}