class Main
{
    public static void foo(String fieldName1, String fieldName2)
    {
        System.out.println(fieldName1 + "," + fieldName2);
    }

    public static void bar(String... fields)
    {
        System.out.println(String.join(",", fields));
    }

    public static void main(String[] args) throws Exception
    {
        final Method foo = Main.class.getMethod("foo", String.class, String.class);
        foo.invoke(null, "aaa", "bbb");

        final Method bar = Main.class.getMethod("bar", String[].class);
        bar.invoke(null, (Object) new String[] {"ccc", "ddd", "eee"});
    }
}