static class ClassA {
    public int a;
    public String b;
    public double c;
}

static class ClassB {
    public int a;
    public String b;
    public double c;
}

public static void main(String[] args) throws Exception {
    ClassA a = new ClassA();
    a.a = 1;
    a.b = "test";
    a.c = 3.14;

    ClassB b = new ClassB();
    copyObject(a, b);
    System.out.println(b.a+", "+b.b+", "+b.c); // prints "1, test, 3.14"
}