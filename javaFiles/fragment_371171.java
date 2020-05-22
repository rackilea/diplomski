@JsonProperty("roles")
    public List<String> getRolesAsStrList() {
        return this.roles
            .stream()
            .map(Role::getName)
            .collect(toList());
    }