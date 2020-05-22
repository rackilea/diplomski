@Id
@GeneratedValue
private long id;

@OneToOne(mappedBy="person")
private Department department;