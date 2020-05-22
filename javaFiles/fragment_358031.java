@Override
public boolean equals(final Object obj) {
    if (obj == this) {
        // we have the same object regarding the pointers (e.g., this.equals(this)), or have a look at 'Manjunath M' post for a different example
        return true;
    } else if (obj == null) {
        // we compare with null (e.g., this.equals(null))
        return false;
    } else if (Contact.class.isInstance(obj.getClass())) {
        /*
         * If you want to be more strict you could also use:
         * getClass().equals(obj.getClass())
         */
        Contact other = Contact.class.cast(obj);
        return Objects.equals(other.getFirstName(), getFirstName()) &&
                Objects.equals(other.getLastName(), getLastName()) &&
                Objects.equals(other.getHomePhone(), getHomePhone()) &&
                Objects.equals(other.getCellPhone(), getCellPhone());
    } else {
        return false;
    }
}