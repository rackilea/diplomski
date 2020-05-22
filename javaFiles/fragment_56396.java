@Entity
public class Address implements Serializable {
    @Id @GeneratedValue(generator = "myForeignGenerator")
    @org.hibernate.annotations.GenericGenerator(
        name = "myForeignGenerator",
        strategy = "foreign",
        parameters = @Parameter(name = "property", value = "user")
    )
    @Column(name = "ADDRESS_ID")
    private Long id;

    @OneToOne(mappedBy="shippingAddress")
    @PrimaryKeyJoinColumn
    User user;

    //...
}