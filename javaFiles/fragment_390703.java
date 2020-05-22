@Entity
@Table(name = "A")
public class A {

    private int id;
    private String b;
    private C c;

    @Id
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Transient
    public C getC() {
        return c;
    }
    public void setC(C c) {
        this.c = c;
    }

    @Column
    protected String getCAsString() {
        return c!=null? c.toString() : null;
    }
    protected void setCAsString(String c) {
        this.c = new C();
        this.c.fromString(c);
    }        
}