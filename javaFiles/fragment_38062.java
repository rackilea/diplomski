@Entity
public class Ent1 implements Serializable {

    private static final long serialVersionUID = -5580880562659281420L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    private Integer a;

    @OneToOne
    @JoinColumn(name="second",  referencedColumnName="parentId", nullable=true) 
    private Ent2 second;

    public void setSecond(Ent2 second) {
        this.second = second;
    }
}