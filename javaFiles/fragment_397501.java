@Entity
@Table(name = "pilgi_document")
public class PilgiDocument {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column
private BigInteger pdocument_id;

@OneToMany(mappedBy = "pdocument_id")
private List<Pilgi> pilgi = new ArrayList();