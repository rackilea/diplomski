class Example1
{
    private int content;

    Example1(int content) {
        this.content = content;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Example1 a = new Example1(42);
        Example1 b = new Example1(42);
        System.out.println(a == b ? "== Same" : "== Different");
        System.out.println(a.equals(b) ? "equals Same" : "equals Different");
    }
}