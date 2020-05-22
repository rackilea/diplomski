@Entity(name = "Base")
@Table(name="Base")
@Inheritance(strategy = InheritanceType.JOINED)
public static abstract class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    protected String x;

    public Long getId() {
        return id;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
}

@Entity(name = "ChildY")
@Table(name="ChildY")
@DiscriminatorValue("Y")
public static class ChildY extends Base {

    private String y;

    @Override
    @org.hibernate.annotations.Index(name = "xy")
    @Access(AccessType.PROPERTY)
    public String getX() {
        return x;
    }
}

@Entity(name = "ChildZ")
@Table(name="ChildZ")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Z")
public static class ChildZ extends Base {

    private String z;

    @Override
    @org.hibernate.annotations.Index(name = "xz")
    @Access(AccessType.PROPERTY)
    public String getX() {
        return x;
    }
}