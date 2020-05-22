public class MyClass {
    private int foo1 = 1;       // visible in this class only
    protected int foo2 = 2;     // visible here, in subclasses and in classes with same package
    int foo3 = 3;               // visible here and in classes with the same package
    public int foo4 = 4;        // visible here, there and everywhere

    /* package */ int foo5 = 5; // how I like to do 'package' variables with a comment
                                //  to show I intended to do it on purpose. If you read
                                //  my code you don't have to wonder if I forgot it.

    ...
}