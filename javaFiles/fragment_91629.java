public static void check(Class c, Class sc, String expected) {
        String actual = getSuperClassType(c, sc).toString();
        if (!actual.equals(expected)) {
            throw new AssertionError(actual + " != " + expected);
        }
    }

    public static void main(String[] args) {
        check(Substitution.class, Map.class, "Map<String, TypeExpr>");
        check(HashMap.class, Map.class, "Map<K, V>");
        check(Bar.class, Foo.class, "Foo<List<? extends String[]>>");
    }
}

interface Foo<X> {

}
class SuperBar<X, Y> implements Foo<List<? extends Y[]>> {

}

class Bar<X> extends SuperBar<X, String> { }