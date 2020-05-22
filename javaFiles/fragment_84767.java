@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Element other = (Element) obj;
    if (eBoolean != other.eBoolean)
        return false;
    if (eInt != other.eInt)
        return false;
    if (eString == null) {
        if (other.eString != null)
            return false;
    } else if (!eString.equals(other.eString))
        return false;
    return true;
}