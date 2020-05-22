@ManyToMany
@JoinTable(
    name="tbl_settings_objectproxy_for_something",
    joinColumns = @JoinColumn(name = "id", columnDefinition = "int primary key"),
    inverseJoinColumns = @JoinColumn( name = "objectproxy_id")
    uniqueConstraints = {@UniqueConstraint(columnNames={"id", "objectproxy_id"})}
    )
private List<SomeObject> SomeObjectProxy;