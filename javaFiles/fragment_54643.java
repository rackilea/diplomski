public DataField(NameAndType<Type> nameAndType) {
    this(nameAndType.name);
    setValue(nameAndType.value);
}

public DataField(String name, String value) {
    this(name);
    setStringValue(value);
}