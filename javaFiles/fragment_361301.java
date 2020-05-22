@Entity
@Table(name="aluno")
public class Aluno implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private Integer id;

    //informacoes gerais
    @NotNull
    private String nome;


    //historico de graduacao
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistoricoDeGraduacao> listaHistoricoGraduacao;


    public Aluno() {
    }

    public void addListaHistoricoGraduacao(HistoricoDeGraduacao hdg){
        if(listaHistoricoGraduacao == null){
            listaHistoricoGraduacao = new ArrayList<HistoricoDeGraduacao>();
        }
        listaHistoricoGraduacao.add(hdg);        
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<HistoricoDeGraduacao> getListaHistoricoGraduacao() {
        return listaHistoricoGraduacao;
    }

    public void setListaHistoricoGraduacao(List<HistoricoDeGraduacao> listaHistoricoGraduacao) {
        this.listaHistoricoGraduacao = listaHistoricoGraduacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return true;
    }    
}


@Entity
@Table(name="graduacao")
public class Graduacao implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private Integer id;

    @NotNull @Column(unique = true)
    private String graduacao;

    @ElementCollection
    @CollectionTable(name="graus_graduacao", joinColumns=@JoinColumn(name="id_graduacao"))
    @Column(name="graus")
    private List<String> graus;

    @OneToMany(mappedBy = "graduacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistoricoDeGraduacao> listaHistoricoGraduacao;

    public Graduacao() {
    }

    public Graduacao(Integer id, String graduacao, List<String> graus) {
        this.id = id;
        this.graduacao = graduacao;
        this.graus = graus;
    }   

    /** adiciona historicodegraduacao a graduacao */
    public void addHistoricoDeGraduacao(HistoricoDeGraduacao hdg){
        if(listaHistoricoGraduacao == null){
            listaHistoricoGraduacao = new ArrayList<HistoricoDeGraduacao>();
        }
        listaHistoricoGraduacao.add(hdg);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public List<String> getGraus() {
        return graus;
    }

    public void setGraus(List<String> graus) {
        this.graus = graus;
    }

    public List<HistoricoDeGraduacao> getListaHistoricoGraduacao() {
        return listaHistoricoGraduacao;
    }

    public void setListaHistoricoGraduacao(List<HistoricoDeGraduacao> listaHistoricoGraduacao) {
        this.listaHistoricoGraduacao = listaHistoricoGraduacao;
    }

    public String toString(){
        return graduacao;
    }
}


@Embeddable
public class HistoricoDeGraduacaoId implements Serializable {
    private static final long serialVersionUID = 1L;

    @JoinColumn(name="EMP_ID")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    } 
}


@Entity
public class HistoricoDeGraduacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    HistoricoDeGraduacaoId pk;

    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_graduacao")
    private Graduacao graduacao;

    private String grau;

    @Temporal(TemporalType.DATE)
    private Date dataGraduou;

    public HistoricoDeGraduacao() {
    }

    public void begin(){
        //instancia pk
        pk = new HistoricoDeGraduacaoId();
        //aqui insiro o id 
        pk.setId(new HistoricoDeGraduacaoDAO().getIndex());
    }


    public HistoricoDeGraduacaoId getPk() {
        return pk;
    }

    public void setPk(HistoricoDeGraduacaoId pk) {
        this.pk = pk;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public Date getDataGraduou() {
        return dataGraduou;
    }

    public void setDataGraduou(Date dataGraduou) {
        this.dataGraduou = dataGraduou;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.aluno);
        hash = 59 * hash + Objects.hashCode(this.graduacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistoricoDeGraduacao other = (HistoricoDeGraduacao) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.graduacao, other.graduacao)) {
            return false;
        }
        return true;
    }    
}


//aqui meu jframe com seus componentes, pegando valores montando tudo para ser salvo
     historico.setDataGraduou(jdp_dataGraduou.getDate());
     historico.setGrau(jl_graus.getSelectedValue().toString());
     //pega graduacao do jcombobox
     Graduacao g = (Graduacao)cbx_graduacao.getSelectedItem();                                
     historico.setGraduacao(g);
     //bean aluno
     historico.setAluno(bean);
     //add a listas
     bean.addListaHistoricoGraduacao(historico);
     g.addHistoricoDeGraduacao(historico);
     //inicia instancia de pk e insere o proximo id     
     historico.begin(); 
     //salva tudo
     new HistoricoDeGraduacaoDAO().update(historico);


//aqui meu DAO
public class HistoricoDeGraduacaoDAO {
    private EntityManager em;

    public HistoricoDeGraduacaoDAO(){
        em = Persistencia.getEntityManager();
    }

    /** pega o ultimo valor da tabela HistoricoDeGraduacao e adiciona + 1 para o proximo indice */
    public Integer getIndex(){
        int count = 0;
        Query query = em.createQuery("SELECT MAX(hdg.pk.id) FROM HistoricoDeGraduacao hdg");
        if(query.getSingleResult() == null){
            ++count;
        }else{
            count = (int)query.getSingleResult() + 1;            
        }
        return count;
    }

    /** executa update */
    public void update(HistoricoDeGraduacao historico){
        try{
            em.getTransaction().begin();        
            em.merge(historico);
            em.getTransaction().commit();
        }catch(PersistenceException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            em.close();
        }
    }
}