@Entity
@Table(name = "TOWN")
public class Town {

    .....

    @OneToMany(mappedBy = "town")
    @OrderBy(clause = "number, subNumber")
    List<House> houses;

    .....

}