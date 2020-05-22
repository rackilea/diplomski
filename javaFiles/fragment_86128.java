@Embeddable
public class Contact
{
    @NotNull
    @NotEmpty
    private String              firstname;
    @NotNull
    @NotEmpty
    private String              lastname;
    @NotNull
    @NotEmpty
    @Email
    @Pattern.List({ @Pattern(regexp = ".+((@domain1\\.com)|(@domain-2\\.com)|(@dom-ain-three\\.com))", message = "Wrong email address") })
    private String              email;
}