@Entity
@Table(name = "es_account")
public class AnagraficaClienti implements Serializable {

private static final long serialVersionUID = 1L;


// da rimettere a @NotNull 
@Column(name = "fk_cod_azienda", nullable = true)
private String fk_cod_azienda;
@Id
@NotNull
@Column(name = "account", nullable = false)
private String account;
// da rimettere a @NotNull
@Column(name = "tipo_cli_for", nullable = true)
private String tipoClienteFornitore;

@Column(name = "tipo_account", nullable = true)
private String tipoAccount;

@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
@JoinColumn(name = "account", nullable = true)
private List<WorkOrder> workOrders;