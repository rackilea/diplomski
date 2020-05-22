public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min=17, max=17, message="VIN number must have 17 characters")
    private String vin;


    @NotEmpty
    @Pattern(regexp="[a-z]*", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String make;

    @NotEmpty
    @Pattern(regexp="[a-z]*", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String model;