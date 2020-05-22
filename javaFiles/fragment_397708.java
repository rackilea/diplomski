@ManyToOne
@Column(name = "birth_region")
private Region birthRegion;


@OneToMany(mappedBy = "birthRegion")
private List<Patient> patientsBirthRegion;