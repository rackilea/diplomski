@Entity
public class Client extends Person {
    @Column(name = "CLIENT_SPECIFIC")
    private String clientSpecific;
    // ...
}

@Entity
public class Affiliate extends Person {
    @Column(name = "AFFILIATE_SPECIFIC")
    private float affiliateSpecific;
    // ...
}