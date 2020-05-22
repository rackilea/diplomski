private StringProperty referenceNumberProperty = new SimpleStringProperty(this, "referenceNumber");
public final StringProperty referenceNumberProperty() {
    return referenceNumberProperty ;
}
public final String getReferenceNumber() {
    return referenceNumberProperty.get() ;
}
public final void setReferenceNumber(String referenceNumber) {
    this.referenceNumberProperty.set(referenceNumber);
}