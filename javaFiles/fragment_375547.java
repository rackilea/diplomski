public class Address {

    @Size(max = 100)
    private String City;

    @NotNull
    @Size(max = 200)
    private String Street;

    @Email
    private String email;

    @CountryCode
    private String countryCode;
}