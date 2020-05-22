@Entity
@Table(name = "Operation", catalog = "TestMvn")
public class Operation extends Base implements java.io.Serializable{

    @Id
    private Long id;

    @ManyToOne  
    private SessionRiu sessionRiu;

    //other mappings here
}