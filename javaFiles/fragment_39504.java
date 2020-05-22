@Entity
@Table(name="SOME_TABLE", schema="SOME_SCHEMA")
public class Outer {
    private Key key;
    // no fields a and b here
    private String c;

    @EmbeddedId
    public Key getId() {
        return this.key;
    }

    // Also a setter for Key...

    @Transient
    public String getA() {
        return this.key.getA();
    }

    public void setA(final String a) {
        this.key.setA(a);
    }

    @Transient
    public String getB() {
        return this.key.getB();
    }

    public void setB(final String b) {
        this.key.setB(b);
    }

    // Also setters and getters for C.
}