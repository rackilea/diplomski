{
  @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "tb_role_privilege",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<Privilege> privileges = new HashSet<>();
}