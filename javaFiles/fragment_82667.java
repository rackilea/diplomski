public interface InterfaceA {
    public int methodA();
    public Number methodB();
    // public int methodC(); // conflicting return type
}

public interface InterfaceB {
    public int methodA();
    public Integer methodB();
    // public String methodC(); // conflicting return type
}

public class ImplementationOfAandB implements InterfaceA, InterfaceB {
    public int methodA() {
        return 0;
    }
    public Integer methodB() {
        return null;
    }
    // This would NOT work:
    // public Double methodB() {
    //     return null;
    // }
}