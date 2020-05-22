@Entity
@Table(name = "user_balance_log")
public class UserBalanceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;

    @ManyToOne
    @JoinColumn(name="adminId")
    private AdminLogin adminId;

    private Float balance;
    private String balanceType;
    private String message;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public AdminLogin getAdminId() {
        return adminId;
    }

    public void setAdminId(AdminLogin adminId) {
        this.adminId = adminId;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }
}