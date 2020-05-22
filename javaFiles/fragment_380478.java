@SuppressWarnings("serial")
@Entity
@Table(name = "key")
public class Key implements java.io.Serializable {

    private int id;
    private String nome;

    public Key() {
    }

    public Key(String nome) {
        this.nome = nome;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nome", unique = true, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}