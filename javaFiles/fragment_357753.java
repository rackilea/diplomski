@Override
public int hashCode() {
    int hash = 0;
    hash += (componentId != null ? componentId.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the componentId fields are not set
    if (!(object instanceof Component)) {
        return false;
    }
    Component other = (Component) object;
    if ((this.componentId == null && other.componentId != null) || (this.componentId != null && !this.componentId.equals(other.componentId))) {
        return false;
    }
    return true;
}

@Override
public String toString() {
    return "com.example.model.Component[ id=" + componentId + " ]";
}