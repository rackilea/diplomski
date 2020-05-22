@Override
public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    return this.remoteAddress.get().equals(((Client) obj).remoteAddress.get());
}

@Override
public int hashCode() {
    int hash = 3;
    hash = 37 * hash + Objects.hashCode(this.remoteAddress.get());
    return hash;
}