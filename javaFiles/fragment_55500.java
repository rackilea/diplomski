public class Person{

    @NotBlank(groups = {FirstValidateGroup.class})
    private String firstName;
    @NotBlank
    private String lastName;

    //... getters and setters
}