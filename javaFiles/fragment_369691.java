@ManyToMany
@JoinTable(
    name = "checkoutsession", // Name of the join table
    joinColumns = @JoinColumn(name = "book"), // The column name in checkoutsession that links to book
    inverseJoinColumns = @JoinColumn(name = "user") // The column name in checkoutsession that links to user
)
private List<User> users;