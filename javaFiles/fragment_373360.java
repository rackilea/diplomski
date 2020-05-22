// Such interfaces you can implement package-private due to visibility purposes
public interface Processor1 {
    String method1(); 
}

public interface Processor2 {
    String method2(); 
}

public class Example {
    private Processor1 p1;
    private Processor2 p2;

    public String methodBeingTested() {
        String m1 = p1.method1();
        String m2 = p2.method2();
        return m2
    }
}