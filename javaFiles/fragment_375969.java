@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
@JsonBackReference
List<Group> groups = new ArrayList<Group>();

@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(name = UserConstants.REFERENCE_GROUP_USER,
 joinColumns = {@JoinColumn(name = "user_group_id")},
 inverseJoinColumns = {@JoinColumn(name = "user_id")}
)
@JsonManagedReference
List<User> users = new ArrayList<User>();