@ManyToOne
@PrimaryKeyJoinColumn(name="STUDENTID", referencedColumnName="id")
private Student student;
@ManyToOne
@PrimaryKeyJoinColumn(name="ADDRESSID", referencedColumnName="id")
private Address address;