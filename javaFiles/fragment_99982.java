//@ManyToOne(cascade=CascadeType.PERSIST)
//@JoinColumn(name="parent_id")
//private Question parent;
@Column(name="parent_id", insertable=false, updatable=false)
private Integer parentId;

//@OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
@JoinColumn(name="parent_id")
private Set<Question> translations;