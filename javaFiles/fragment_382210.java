public class ObjectTest {
    private static final ObjectTest instanceObj = new ObjectTest();

    private ObjectTest() {
    }

    public static ObjectTest getInstance() {
        return instanceObj;
    }

    public static void main(String[] args) {

        ObjectTest localObj = ObjectTest.getInstance();
    }
}