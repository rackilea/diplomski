class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        new Child().test(5);
    }
}
class Parent {
    public void test(int a){
        System.out.println(a);
    }
}

class Child extends Parent{
    @Override
    public void test(int a){
        super.test(a);
        a++;
    }
}