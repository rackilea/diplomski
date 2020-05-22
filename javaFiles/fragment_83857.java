@Override
public boolean equals(Object obj) {
    if (obj instanceof Customer) {
        Customer other = (Customer) obj;
        return this.getAcNumber().equals(other.getAcNumber());
    }
    return false;
}