@Override
public boolean equals(Object o) {
    if (!(o instanceof Foo)) {
        return false;
    }
    Foo foo = (Foo) o;
    return name.equals(foo.name);
}