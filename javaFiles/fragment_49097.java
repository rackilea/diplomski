@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Transient
    Collection<String> files;

    public Long getId() {
        files = Utils.getImages("" + id, "src/main/webapp/user/");
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<String> getFiles() {
        return files;
    }

    public void setFiles(Collection<String> files) {
        this.files = files;
    }
}