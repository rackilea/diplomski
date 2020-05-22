public class Address {

    @NotNull private String line1;
    private String line2;
    private String zip;
    private String state;

    @Length(max = 20)
    @NotNull
    private String country;

    @Range(min = -2, max = 50, message = "Floor out of range")
    public int floor;

        ...
}