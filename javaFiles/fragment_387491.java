private static <T> void doSomething(T[] array){
    ...
}
public static void main (String[] args) throws java.lang.Exception {
    doSomething(new String[10]); // Compiles fine
    doSomething(new int[10]);    // Compile-time error
}