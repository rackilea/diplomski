import java.util.Arrays;

class Example
{
    Example(String... strings) {
        System.out.println("strings = " + Arrays.toString(strings));
        // Obviously, in the normal case, a constructor actually does something
        // with the parameters...
    }

    static Example create(String... strings) {
        return new Example(strings);
    }

    public static void main(String[] args)
    {
        Example e = Example.create("a", "b", "c");
    }
}