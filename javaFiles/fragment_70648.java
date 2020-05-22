@Setter
@Getter
@Entity
public class Episodio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepisodio")
    private Integer idepisodio;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "objetivoEpisodio")
    private String objetivoEpisodio;

    @Column(name = "descripcionEpisodio")
    private String descripcionEpisodio;

    @Column(name = "recursosEpisodio")
    private String recursosEpisodio;

    @Column(name = "restriccionEpisodio")
    private String restriccionEpisodio;

    @Column(name = "actor")
    private String actor;
    @JoinTable(name = "especificacionEscenarioEpisodio",
            joinColumns = {
                @JoinColumn(name = "idepisodio", referencedColumnName = "idepisodio")},
            inverseJoinColumns = {
                @JoinColumn(name = "idespecificacionEscenario", referencedColumnName = "idespecificacionEscenario")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EspecificacionEscenario> especificacionEscenarioList;

}




@Setter
@Getter
@Entity
public class EspecificacionEscenario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespecificacionEscenario")
    private Integer idespecificacionEscenario;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "nombreProceso")
    private String nombreProceso;

    @Column(name = "nombreEscenario")
    private String nombreEscenario;

    @Column(name = "objetivoEscenario")
    private String objetivoEscenario;

    @Column(name = "lugarEscenario")
    private String lugarEscenario;

    @Column(name = "recursoEscenario")
    private String recursoEscenario;

    @Column(name = "restriccionEscenario")
    private String restriccionEscenario;

    @Column(name = "actoresEscenario")
    private String actoresEscenario;

    @ManyToMany(mappedBy = "especificacionEscenarioList", fetch = FetchType.LAZY)
    private List<Episodio> episodioList;

}


EspecificacionEscenario especificacionEscenario = new EspecificacionEscenario();
especificacionEscenario.setCodigo("ee-01");

List<EspecificacionEscenario> especificacionEscenarios = new ArrayList<>();
especificacionEscenarios.add(especificacionEscenario);


Episodio episodio = new Episodio();
episodio.setCodigo("e01");
episodio.setDescripcionEpisodio("descripcion episodio");
episodio.setEspecificacionEscenarioList(especificacionEscenarios);

episodioRepo.save(episodio);