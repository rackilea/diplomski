public class ConcreteTest extends AbstractTest {
    @Override
    public int getNum() {
        return 22;
    }
}

public static void main (String [] args) {
    ConcreteTest t = new ConcreteTest();
    System.out.println(t.getNum());
}