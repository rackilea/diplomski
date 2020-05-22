public class Utilisateur implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(nullable = false)
private Integer id;
@Column(length = 2147483647)
private String nom;
private Integer theme;
@JoinTable(name = "utilisateur_prvilege", schema = "sch_admin", joinColumns = {
    @JoinColumn(name = "utilisateur", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "privilege", referencedColumnName = "id")})
@ManyToMany(cascade = CascadeType.ALL)
private List<Privilege> privilegeList = new ArrayList<>();

..getters and setter..

}