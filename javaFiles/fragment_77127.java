public class BooleanTest {
    private int num;
    private boolean isMatch;

    public BooleanTest() {
        num = 10;
    }

    public boolean isMatch() {
        return num == 10;
    }

    public static void main(String[] args) {
        BooleanTest test = new BooleanTest();
        System.out.println(test.isMatch()); // true
        System.out.println(test.isMatch); // false
    }
}