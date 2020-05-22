@Entity(name = "user")
static class User extends AbstractPersistable<String> {
    private String username;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //by default fetching is lazy
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_roles"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return this.roles;
    }
}

@Entity(name = "role")
static class Role extends AbstractPersistable<String> {
    private String name;

    private Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}