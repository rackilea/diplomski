public class MyClass {

    {
        b = 10;
    }
    int a = this.b;
    int b = 5;
    {
        b = 15;
    }

    public static void main(String[] args) {
        MyClass m = new MyClass();
        System.out.println(m.a); //10
        System.out.println(m.b); //15
    }
}