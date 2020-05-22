equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(obj instanceof MyClass)) return false;
    MyClass other = (MyClass) obj;
    if (this.longArray == other.longArray) return true;
    if (Arrays.equals(this.longArray, other.longArray)) {
        this.longArray = other.longArray;
        return true;
    }
    return false;
}