@Embeddable
public class AppUserSecurityQuestionId implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name="AppUserId")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name="SecurityQuestionId")
    private SecurityQuestion securityQuestion;
    ...
}