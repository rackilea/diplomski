class My {
    private final List<String> xs;
    private final List<Integer> ys;

    My(List<String> xs, List<Integer> ys) {
        this.xs = xs;
        this.ys = ys;
    }

    public List<Integer> getYs() {
        return ys;
    }

    public List<String> getXs() {
        return xs;
    }

    @Override
    public int hashCode() {
        return xs.hashCode() + 7 * ys.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof My))
            return false;
        My o = (My) obj;
        return
                // ignoring order
                getXs().stream().sorted().collect(toList()).equals(o.getXs().stream().sorted().collect(toList()))
                // checking order
                && getYs().equals(o.getYs());
    }
}

public class Callme {
    public static void main(String... args) {
        My m1 = new My(asList("a", "b"), asList(1, 2));
        My m2 = new My(asList("b", "a"), asList(1, 2));
        My m3 = new My(asList("a", "b"), asList(2, 1));
        System.out.println(m1.equals(m2));
        System.out.println(m1.equals(m3));
    }
}