public class Person {
    @NotNull
    private int id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String firstName;

    @NotBlank
    @Pattern(regexp ="[SOME REGULAR EXPRESSION]")
    private String lastName;

    @Min(0)
    @Max(100)
    private int age;

    //... Constructor, getters, setters, ...
}