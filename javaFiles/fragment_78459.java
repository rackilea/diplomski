class Example2
{
    private int content;

    Example2(int content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        Example2 other = (Example2)obj;
        return this.content == other.content;
    }

    @Override
    public int hashCode() {
        return this.content;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Example2 a = new Example2(42);
        Example2 b = new Example2(42);
        System.out.println(a == b ? "== Same" : "== Different");
        System.out.println(a.equals(b) ? "equals Same" : "equals Different");
    }
}