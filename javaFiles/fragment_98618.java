@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid")
@Column(name = "application_id")
@Size(max = 32)
private String applicationId;