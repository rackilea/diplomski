@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Raadplegingen")
@NamedQueries({
    @NamedQuery(name = "ClubRaadpleging.getAlleRaadplegingen",
            query = "SELECT r FROM ClubRaadpleging r"),
    @NamedQuery(name = "ClubRaadpleging.findByLes",
            query = "SELECT r FROM ClubRaadpleging r WHERE r.les.id  = :lesId")
})
public class ClubRaadpleging implements Serializable {