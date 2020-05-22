public class B extends A {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof B))
            return false;
        B other = (B) obj;
        return this.someProperty.equals(other.someProperty) && this.secondProperty.equals(other.secondProperty);
    }
}