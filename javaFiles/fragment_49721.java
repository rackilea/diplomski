@PersistenceUnit(unitName="persistenceUnit")
@Entity
@Table(name = "customer", schema = "customerDb")
public class CustomerEntity {
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
..................
}