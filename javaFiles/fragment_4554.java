@Entity
public class SecondEntity implements Serializable {
    @PrePersist
    public void prePersist() {
        if (dateInserted == null) {
            dateInserted = new Date();
        }
    }
}