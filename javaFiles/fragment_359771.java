// in PropertyBuilder append these lines
public PropertyBuilder setSerializedName(String sname) {
    // Check the sname on correctness (i.e. not empty, not containing illegal characters)
    property.serializedName = sname;
    return this;
}

// in Property append these lines
private String serializedName = null;

public boolean isSerialized() {
    return serializedName != null;
}