@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
@JoinTable(name="container_mapping",
     joinColumns = @JoinColumn(name="internal_id"),
     inverseJoinColumns = @JoinColumn(name="external_id")
@WhereJoinTable(clause="mapping_type_id=2")
private List<Video> videos = Lists.newArrayList();