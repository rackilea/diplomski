@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name= "Wall_Follower",
        joinColumns = { @JoinColumn(name = "wall_id") },
        inverseJoinColumns = { @JoinColumn(name = "follower_id") }
    )
    private Set<Follower> followers;