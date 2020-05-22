public class UserRegistration {

    @NotNull
    @Size(max=7)
    private String name;
    @Min(0)
    private int houseNo;
    ...
}