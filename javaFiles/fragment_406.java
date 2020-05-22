public class Test {
    public static void main(String[] args) {
        Predicate<String> isNullOrEmpty = Test.<String>isNull().or(isEmpty());
        System.out.println(isNullOrEmpty.test(null));   // true
        System.out.println(isNullOrEmpty.test(""));     // true
        System.out.println(isNullOrEmpty.test("Foo"));  // false
    }
    private static <T> Predicate<T> isNull(){
        return Objects::isNull;
    }
    private static Predicate<String> isEmpty(){
        return string -> string.isEmpty();
    }
}