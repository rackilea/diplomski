Class Another{ 

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="hall_id")

Set<Literature> literatures;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="hall_id")

Set<RecycleFacility> recycleFacilities;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="hall_id")

Set<Assent> assents;
// getter/setter
}