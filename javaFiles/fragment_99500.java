class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        foo(args);
    }

    private static void foo(String... params) {
        System.out.println(Arrays.toString(params));
    }
}