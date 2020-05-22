@Entity
@Table(name = "t_person")
// Sequence Definition removed
public class Person extends AbstractEntity {

    @OneToMany(mappedBy = "person", targetEntity = PictureRef.class)
    private List<PictureRef> pictures;

    ...

}