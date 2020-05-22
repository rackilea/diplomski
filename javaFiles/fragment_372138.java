// in Parent
@OneToMany(cascade=CascadeType.REMOVE, mappedBy="parent")
List<Item> children = new ArrayList<Child>();

// in Child
@ManyToOne
Parent parent;