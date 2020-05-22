public class Example {

    public static void main(String[] args) throws Exception {
        ClassesHolder<One> ones = new ClassesHolder<One>();
        ones.add(new SubOne());
        ones.add(new SubSubOne());
    }

}

interface Zero {}
interface One extends Zero {};
interface Two extends Zero {};
class SubOne implements One {};
class SubSubOne implements One {};
class SubTwo implements Two {};
class SubSubTwo implements Two {};

class ClassesHolder<V extends Zero> {
    public <T extends V> void add(T item) {}
}