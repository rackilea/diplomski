@Override
public boolean equals(Object other) {
    if (!(other instanceof MyClass)) {
        return false;
    }

    MyClass that = (MyClass) other;

    // Custom equality check here.
    return this.field1.equals(that.field1)
        && this.field2.equals(that.field2);
}