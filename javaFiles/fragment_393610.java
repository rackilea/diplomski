public int hashCode() {
    int result = 17;
    result = 31 * result + field1;   (int)
    result = 31 * result + field2.hashCode();   (Object)
    ... for the rest of the fields.
    return result;
}