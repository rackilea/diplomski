public class InitTest {
    static InitTest test = new InitTest();

    private int count = 0;

    public static void main(String[] args) {

    }

    public InitTest() {
        test.count++;
    }
}