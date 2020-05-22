@Entity
public class Magazine {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "id.magazine")
    private Set<Subscription> subscriptions;

    // ..

}

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "id.customer")
    private Set<Subscription> subscriptions;

    // ..
}

@Entity
public class Subscription {
    private Date start;
    private Date end;

    @EmbeddedId
    private SubscriptionId id;

    // ..
}

@Embeddable
public class SubscriptionId implements Serializable {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Magazine magazine;

    // ..
}