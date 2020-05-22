public class DummyDummy {

private int x = 0;
private Inner i = new Inner();
private int foo(int a, int b) {
    return a+b+x;
}

private class Inner {
    void doIt() {
        System.out.println(
         // Here, DummyDummy.access$0(DummyDummy, int, int) is called 
         // which calls DummyDummy.foo(int, int)
             foo(1,2)                 );
    }
}

public static void main(String[] args) {
    new DummyDummy().i.doIt();
}

}