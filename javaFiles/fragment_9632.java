@Id
@GeneratedValue(generator="gen")
@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="person"))
private long id;

@OneToOne
@PrimaryKeyJoinColumn
private Person person;