@Entity
@Table(name = "work_order")
public class WorkOrder implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
@SequenceGenerator(name = "sequenceGenerator")
private Long id;

@NotNull
@Column(name = "id_order", nullable = false)
private String idOrder;

@Column(name = "description")
private String description;

@Enumerated(EnumType.STRING)
@Column(name = "status")
private StatusOrder status;

@Column(name = "creation_date")
private Instant creationDate;

@Column(name = "closing_date")
private Instant closingDate;

@Column(name = "client_id")
private Long clientId;