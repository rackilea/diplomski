public class A{
    int i;
}

public class B extends A{
    int i;

    void test(){
        this.i = 8;
        super.i = 10;
        System.out.println("super.i = " + super.i);
        System.out.println("this.i = " + this.i);
    }
}