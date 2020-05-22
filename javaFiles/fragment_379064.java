public class Validation {

    private Long validationId;
    private User user;

    @Id
    @GeneratedValue(generator="SharedPrimaryKeyGenerator")
    @GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="user"))
    @Column(name = "VALIDATION_ID", unique = true, nullable = false)
    public Long getValidationId(){
        return validationId;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

}