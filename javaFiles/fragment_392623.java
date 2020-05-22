@Override
public int hashCode() {
    return new HashCodeBuilder().append(userKey)
                                .append(id)
                                .append(userEntity)
                                .toHashCode();
}