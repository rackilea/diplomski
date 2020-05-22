public int hashCode() {
    int h = className.hashCode() * 23;
    h += methodName.hashCode() * 17;
    h += uniqueNumber;
    return h;
}