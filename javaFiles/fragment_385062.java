@Id
@GeneratedValue
@Column(name = "auid")
private int autherId;

@OneToMany
@JoinColumn(name = "auid")
private Set<BookMasterTable> bookMasterTables;