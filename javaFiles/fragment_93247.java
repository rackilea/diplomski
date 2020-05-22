@Override
public final int hashCode() {
    return this.getClass().getName().hashCode();
}

@Override
public final boolean equals(Object other) {
    if (other == this) {
        return true;
    }
    if (other == null) {
        return false;
    }
    return other.getClass().equals(this.getClass());
}