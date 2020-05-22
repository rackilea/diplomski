@Id
@Column(name = "id", unique = true, nullable = false)
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Integer id;

@Column(name="enumField", nullable = false)
@Enumerated(EnumType.ORDINAL)
private EnumType enumField;

@Basic
@Column(name="myField")
private int myField = 0;

@ManyToOne
@JoinColumn(name="fooInstance", nullable = false)
private Foo fooInstance;