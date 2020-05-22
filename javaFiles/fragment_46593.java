public class Material extends Comparable<Material> {
    final int a;
    final String b;
    ...

    public Material(int a, String b, ...) {
        this.a = a;
        this.b = b;
    }

    @Override
    int compareTo(Material other) {
        int cmp = Integer.compare(a, other.a);
        if (cmp == 0) {
            cmp = b.compareTo(other.b);
        }
        ...
        return cmp;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Material)) {
            return false;
        }
        return compareTo((Material) other) == 0;
    }

    @Override int hashCode() {
        return ...;
    }