public interface Instantiator{
    public int getNumber();
}

public class A1 implements Instantiator{
    private B b;
    public A() {
        b = new B(this);
    }

    public int getNumber(){
        return 5;
    }
}

public class C implements Instantiator{
    private B b;
    private int count = 0;

    public C(){
        count++;
        b = new B(this);
    }

    public int getNumber(){
        return count;
    }
}

public class B {

    public final Instantiator instant;

    public B(Instantiator a) {
        instant = a;
        System.out.println(a.getNumber());
    }
}