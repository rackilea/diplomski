@Entity
@Table(name="produto")
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome", length=32, nullable=false, unique=true)
    @Order(value=1)
    private String nome;

    @Column(name="titulo", length=32, nullable=false)
    @Order(value=2)
    private String titulo;

    @Column(name="preco")
    @Order(value=3)
    private Float preco;

    @OneToOne
    @JoinColumn(name="categoria")
    @Order(value=4)
    private Categoria categoria;

    @Column(name="descricao", length=65535)
    @Order(value=5)
    private String descricao;

    @Column(name="destaque")
    @Order(value=6)
    private boolean destaque;
}