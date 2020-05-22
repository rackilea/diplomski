package parent;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(Main.class.getMethod("bar").getGenericReturnType());
        // prints "parent.Main.parent.Main$Bar<T>"
    }

    public <T> Bar<T> bar() {
        return null;
    }

    /*static*/ class Bar<T> {}

}