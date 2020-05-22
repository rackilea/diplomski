@Entity
public class Community extends GenericModel {
    @Id
    public Long id;

    public Community (Long id) {
        this.id = id;
    }
}