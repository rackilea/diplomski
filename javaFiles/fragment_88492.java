public class DemoClass {
    private int x;
    private int y;
    public void setValue(int a, int b)
    {
        this.x=a;
        this.y=b;
    }
    public void getValue()
    {
        System.out.println(this.x);
        System.out.println(this.y);
    }
    public static void main(String[] args)
    {
        DemoClass dc=new DemoClass();
        tc.setValue(10, 20);
        tc.getValue();
    }
}