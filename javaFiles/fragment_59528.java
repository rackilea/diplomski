@Override
public String toString() {
    //same convention as AbstractMap.SimpleEntry
    return key + "=" + value;
}

@Override
public boolean equals(Object o) {
    if(o == this) return true;
    if(!(o instanceof Pair)) return false;

    Object otherKey = ((Pair<?, ?>)o).getKey();
    Object otherValue = ((Pair<?, ?>)o).getValue();
    return (key == null ? otherKey == null : key.equals(otherKey))
            && (value == null ? otherValue == null
                    : value.equals(otherValue));
}

@Override
public int hashCode() {
    return 17 + 55555 * (key == null ? 72 : key.hashCode())
            + 232323 * (value == null ? 73 : value.hashCode());
}