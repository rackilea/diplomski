public class ApiParameters {
    @NotNull(message = "is empty")
    @Email(message = "is not an email")
    private String email;
    @NotNull(message = "is required")
    private String postalCode;

    public ApiParameters() {
    }

    // Getters + Setters
}