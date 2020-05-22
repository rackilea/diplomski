public class Pair<T, U> {
    //...

    @Override
    public int hashCode() {
        return one.hashCode() + two.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair))
            return false;
        Pair p = (Pair) obj;
        return p.one.equals(one) && p.two.equals(two);
    }
}