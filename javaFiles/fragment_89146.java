@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
            + ((conceptPk == null) ? 0 : conceptPk.hashCode());
    return result;
}

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
    Concept other = (Concept) obj;
    if (conceptPk == null) {
        if (other.conceptPk != null) {
            return false;
        }
    } else if (!conceptPk.equals(other.conceptPk)) {
        return false;
    }
    return true;
}