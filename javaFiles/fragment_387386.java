@Entity
@Table(name = "comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;

    @ELementCollection
    @CollectionTable(name = "comercio_telefone", 
                joinColumns=@JoinColumn(name="comercio_id"))
    private List<String> telefones;

    private String email;
}