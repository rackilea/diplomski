class Field {
    @XmlTransient
    String fieldName;
    @XmlValue
    String fieldValue;
}

class Holder {
    @XmlVariableNode("fieldName")
    Field field;
}