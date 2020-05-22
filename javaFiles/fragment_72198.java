public Polynomial clone() {
    try {
        Polynomial p = (Polynomial)super.clone();
        p.pol = this.pol.clone();
        return p;
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }
    return null;
}