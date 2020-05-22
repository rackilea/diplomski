@Entity
public class User {

    @Column @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @PreUpdate
    public void onUpdate() {
        lastUpdate = new Date();
    }

}