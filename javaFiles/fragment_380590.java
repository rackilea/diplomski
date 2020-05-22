@Entity
public class CarPictureRef extends PictureRef {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    ...

}