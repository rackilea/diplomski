public class ObjectTest {
    private static ObjectTest instanceObj;

    private ObjectTest() {
    }

    public static ObjectTest getInstance() {
        if (instanceObj != null) {
            instanceObj = new ObjectTest();
        }
        return instanceObj;
    }

    public static void main(String[] args) {

        ObjectTest localObj = ObjectTest.getInstance();
    }
}