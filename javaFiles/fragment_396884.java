public class Utils {

    public static <O, T> T nvl(O value, Function<O, T> method, T nullSubstition) {
        return value == null ? nullSubstition : method.apply(value);
    }

    static class NamedObject {
        String getName() {
            return "foo";
        }
    }

    public static void main(String[] args) {
        NamedObject foo = null;
        String name = Utils.nvl(foo, NamedObject::getName, "bar");
        System.out.println("name = " + name); // name = bar

        foo = new NamedObject();
        name = Utils.nvl(foo, NamedObject::getName, "bar");
        System.out.println("name = " + name); // name = foo
    }
}