@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MailingAddress)) return false;
    MailingAddress ma = (MailingAddress) o;
    return getId() != null && Objects.equals(getId(), ma.getId());
}

@Override
public int hashCode() {
    return 31;
}