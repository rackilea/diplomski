@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

    private static final long serialVersionUID = -7283129128268761582L;

    private int id;
    private String login;
    private String senha;
    private String primeiroNome;
    private String ultimoNome;
    private Tipo tipo;
    private ConfigHorarioLivre config;
    private List<Atributo> atributo;
    private List<Autorizacao> autorizacao;
    private List<HorarioLivre> horario_livre;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.setLogin(login);
        this.setSenha(senha);
    }

    public Usuario(String login, String senha, String primeiroNome, String ultimoNome, Tipo tipo, List<Atributo> atributos) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setPrimeiroNome(primeiroNome);
        this.setUltimoNome(ultimoNome);
        this.tipo = tipo;
        this.atributo = atributos;
        this.config = new ConfigHorarioLivre();
        this.autorizacao = new ArrayList<Autorizacao>();
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "primeiro_nome")
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    @Column(name = "ultimo_nome")
    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="fk_tipo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="atributo_usuario", joinColumns={@JoinColumn(name="fk_usuario")}, inverseJoinColumns={@JoinColumn(name="fk_atributo")})
    public List<Atributo> getAtributo() {
        return atributo;
    }

    public void setAtributo(List<Atributo> atributo) {
        this.atributo = atributo;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_config")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public ConfigHorarioLivre getConfig() {
        return config;
    }

    public void setConfig(ConfigHorarioLivre config) {
        this.config = config;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="autorizacao_usuario", joinColumns={@JoinColumn(name="fk_usuario")}, inverseJoinColumns={@JoinColumn(name="fk_autorizacao")})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Autorizacao> getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(List<Autorizacao> autorizacao) {
        this.autorizacao = autorizacao;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="horariolivre_usuario", joinColumns={@JoinColumn(name="fk_usuario")}, inverseJoinColumns={@JoinColumn(name="fk_horariolivre")})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<HorarioLivre> getHorario_livre() {
        return horario_livre;
    }

    public void setHorario_livre(List<HorarioLivre> horario_livre) {
        this.horario_livre = horario_livre;
    }

}