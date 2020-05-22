@SuppressWarnings({ "unchecked" })
public <T> T getTypedValue(String functionName, String value) {
    ReturnType type = this.getReturnType(functionName);
    switch(type) {
        case DOUBLE:
        case FLOAT:
        case JSON:
        case IP_ADDRESS:
            break;
        case INTEGER:
            return (T) Integer.valueOf(value);
        case STRING:
        case UNKNOWN:
        default:
            return (T) value;
    }
    return null;
}