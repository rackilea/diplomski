public class Person {

    @Size(min=4, max=10)
    private String name;

    @Range(min=0, max=80)
    private Integer age;

    @NotEmpty
    private String address;

    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @Past
    private Date birth;

    @Valid  // This line   
    private Pet pet;

}