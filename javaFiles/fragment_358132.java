@Override
public boolean equals(Object other) {
    if (other == null) { return false; }
    if (!(other instanceof MyString)) { return false; }
    MyString m = (MyString)other;
    return this.string.equals(m.string);
}