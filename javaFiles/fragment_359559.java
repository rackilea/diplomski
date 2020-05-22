@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 2, max = 25)
    @Column(unique = true)
    private String login;

    @NotEmpty
    @Size(min = 6)
    private String senha;

    @Transient
    private String confirmSenha;

    private Boolean status;

    @OneToMany(mappedBy = "usuario")
    private List<Papel> papeis;

    <!-- Getters/Setters... -->
}