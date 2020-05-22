public class User implements Serializable {

...

    @Column(name = "membership_number")
    private String membershipNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

...

}