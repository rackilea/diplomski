public class PersonDTO {

    @NotEmpty(message = "Name is required")
    private String name;

    ...
}