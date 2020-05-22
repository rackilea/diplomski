@Entity
@Table(name = "CONTACT", schema = "name")
public class Contact {

    @Id
    private Integer id;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }