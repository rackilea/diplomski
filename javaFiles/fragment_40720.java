@Entity(name = "Tag")
@Table(name = "tag")
@EntityListeners(AuditListener.class)
public class Tag implements Auditable {

    @Id
    private String name;

    @Embedded
    private Audit audit;

    //Getters and setters omitted for brevity
}