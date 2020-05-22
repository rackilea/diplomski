@Override
public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 37 + this.field1.hashCode();
    hashCode = hashCode * 37 + this.field2.hashCode();

    return hashCode;
}