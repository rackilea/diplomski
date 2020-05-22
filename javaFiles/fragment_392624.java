@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    UserKeyEntity other = (UserKeyEntity) obj;
    return new EqualsBuilder().append(userKey, other.userKey)
                              .append(id, other.id)
                              .append(userEntity, other.userEntity)
                              .isEquals();
}