class Example
{
    Example(int a) {
        System.out.println("one param: " + a);
        // ...
    }

    Example(int a, int b) {
        System.out.println("two params: " + a + ", " + b);
        // ...
    }

    Example(int a, int b, int c) {
        System.out.println("three params: " + a + ", " + b + ", " + c);
        // ...
    }

    static Example create(int... ints) {
        switch (ints.length) {
            case 1:
                return new Example(ints[0]);
            case 2:
                return new Example(ints[0], ints[1]);
            case 3:
                return new Example(ints[0], ints[1], ints[2]);
            default:
                throw new IllegalArgumentException("Only 1-3 ints allowed");
        }
    }

    public static void main (String[] args)
    {
        Example e = Example.create(1, 2, 3);
    }
}