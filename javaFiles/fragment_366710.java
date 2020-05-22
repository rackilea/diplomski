@Entity
public class Client {

    @Id
    @GeneratedValue
    private int cid;

    @Column(name = "firstname", nullable = false)
    private String fname;

    @Column(name = "lastname", nullable = false)
    private String lname;

    private String email;
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;
    int age;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    // rest of getters / setters
}