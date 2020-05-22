/**
     * Returns the roles List.
     */
    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinTable(name = "ACCOUNT_ROLE", joinColumns = @JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(cascade = PERSIST)
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Set the roles List.
     * It is recommended to use the helper method addRole /  removeRole
     * if you want to preserve referential integrity at the object level.
     *
     * @param roles the List of Role
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Helper method to add the passed role to the roles List.
     */
    public boolean addRole(Role role) {
        return getRoles().add(role);
    }

    /**
     * Helper method to remove the passed role from the roles List.
     */
    public boolean removeRole(Role role) {
        return getRoles().remove(role);
    }

    /**
     * Helper method to determine if the passed role is present in the roles List.
     */
    public boolean containsRole(Role role) {
        return getRoles() != null && getRoles().contains(role);
    }