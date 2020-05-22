@Id
@SequenceGenerator(name = "userID", sequenceName = "userID")
@GeneratedValue(strategy = GenerationType.AUTO, generator = "userID")
@Column(name = "id")
private Long id;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Role role;