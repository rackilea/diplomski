@Entity(name = "Tag")
@Table(name = "tag")
public class Tag {

    @Id
    private String name;

    @Embedded
    private Audit audit = new Audit();

    //Getters and setters omitted for brevity
}