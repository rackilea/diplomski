public static void function(String s, Consumer<String> f) {
    f.accept(s);
}

public static void main(String args[]) {
    String test1 = "test";
    String test2 = "test2";
    function(test1, System.out::println);
    function(test2, System.out::println);
    function(test1, System.out::print);
    function(test2, System.out::print);
}