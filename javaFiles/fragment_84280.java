@ManyToOne
@JoinColumn(name = "destination_country_id", referencedColumnName = "id", table = "countries", insertable = false, updatable = false)
private Country country;

@Column(name = "name", table = "countries")
public String country_name;