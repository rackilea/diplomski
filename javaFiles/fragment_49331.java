@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name="entity_descriptioncomments")
@IndexColumn(base = 1, name = "dnr")
private List<Comment> descriptionComments = new ArrayList<Comment>();

@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name="entity_postmortemcomments")
@IndexColumn(base = 1, name = "pmnr")
private List<Comment> postMortemComments = new ArrayList<Comment>();