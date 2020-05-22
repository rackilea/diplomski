class Foo {
    ....

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Foo other = (Foo) obj;
        return boo == other.boo;
    }

    @Override
    public int hashCode() {
        return boo;
    }
}