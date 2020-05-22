@Override
public int hashCode() {
    int hash = 7;
    hash = 31 * hash + Objects.hashCode(this.roleid);
    hash = 31 * hash + Objects.hashCode(this.rolename);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Role other = (Role) obj;
    if (!Objects.equals(this.roleid, other.roleid)) {
        return false;
    }
    if (!Objects.equals(this.rolename, other.rolename)) {
        return false;
    }
    return true;
}