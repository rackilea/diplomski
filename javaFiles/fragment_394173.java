@JsonIgnore
public PK getPk() {
    if (pk == null) {
        pk = new PK();
    }

    return pk;
}

public void setPk(PK pk) {
    this.pk = pk;
    this.user = new User(pk.getUser());
    this.permission = new Permission(pk.getPermission());
}

public User getUser() {
    if (user == null) {
        user = new User(getPk().getUser());
    }

    return user;
}

public void setUser(User user) {
    this.user = user;
    getPk().setUser(user.getId());
}

public Permission getPermission() {
    if (permission == null) {
        permission = new Permission(getPk().getPermission());
    }

    return permission;
}

public void setPermission(Permission permission) {
    this.permission = permission;
    getPk().setPermission(permission.getId());
}