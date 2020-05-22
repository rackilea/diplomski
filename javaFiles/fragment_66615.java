@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class TelephoneNumberAssignment implements Serializable {

    @Id String numberString;

    @MapsId
    @OneToOne
    @JoinColumn(name="number")
    private TelephoneNumber number;

    ... getters and setters ...
}