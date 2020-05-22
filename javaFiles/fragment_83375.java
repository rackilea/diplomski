@Override
public String toString() {
    return new org.apache.commons.lang3.builder.ToStringBuilder(this).
        append("field1", field1).
        append("field2", field2).
        toString();
}