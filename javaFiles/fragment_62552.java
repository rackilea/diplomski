class Ideone
{
    static Object[] objects = new Object[2];

    public static void main (String[] args) throws java.lang.Exception
    {
        M1();
        M2();
        System.gc();
    }

    static void M1() {
        objects[0] = new Foo().Bar();
    }
    static void M2() {
        objects[1] = new Foo().Baz();
    }
}

class Foo {
    static int i = 0;
    int j = i++;

    public Foo() {
        System.out.println("Constructed: " + j);
    }

    Object Bar() {
        return new Object() {

        };
    }
    static Object Baz() {
        return new Object() {

        };
    }

    protected void finalize() throws Throwable {
        System.out.println("Garbage collected " + j);
    }
}