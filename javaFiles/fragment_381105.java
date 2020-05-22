@Entity
public class PoPart extends UUIDIdentified {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    Po po;

    @ManyToOne
    Part part;

    public Po getPo() {
        return po;
    }

    public void setPo(Po po) {
        this.po = po;
    }
}