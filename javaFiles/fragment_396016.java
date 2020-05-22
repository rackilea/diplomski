@OneToMany(fetch = FetchType.LAZY, mappedBy = "foo")
@Fetch(value = FetchMode.SUBSELECT)
@Cascade(value = {CascadeType.ALL})
private Set<Bar> bar = new LinkedHashSet<Bar>(0);

...

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FOOID", referencedColumnName = "FOOID")
private Foo foo;