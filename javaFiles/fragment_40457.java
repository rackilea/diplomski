@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    A other = (A) obj;
    if (id == other.id)
        return true;
    if (id == null)
        return false;
    if (other.id == null)
        return false;
    if (!this.id.equals(other.id))
        return false;
    return true;
}