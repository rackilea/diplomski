@Entity
public class Ent2 implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1554968351865549494L;

    @EmbeddedId
    private Ent2Id id;

    public Ent2Id getId() {
        return id;
    }

    public void setId(Ent2Id id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    Integer parentId;
}