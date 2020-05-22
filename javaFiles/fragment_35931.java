@Override
public String getAttributeLocalName(int index) {
    return super.getAttributeLocalName(index).toLowerCase().intern();
}

@Override
public String getLocalName() {
    return super.getLocalName().toLowerCase().intern();
}