@Entity
public class Part extends UUIDIdentified {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "part", targetEntity = PoPart.class)
    List<PoPart> poParts;

    public List<PoPart> getPoParts() {
        return poParts;
    }

    public void setPoParts(List<PoPart> poParts) {
        this.poParts = poParts;
    }
}