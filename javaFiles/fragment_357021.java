public class ReflectionTest {

interface Test {
    void test();
}

class TestImpl implements Test {

    @Override
    public void test() {
    }

}

private static boolean isInterfaceMethod(Class clazz, String methodName) throws NoSuchMethodException, SecurityException {
    for (Class interfaze : clazz.getMethod(methodName).getDeclaringClass().getInterfaces()) {
        for (Method method : interfaze.getMethods()) {
            if (method.getName().equals(methodName)) {
                return true;
            }
        }
    }

    return false;
}

public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        System.out.println(isInterfaceMethod(TestImpl.class, "test")); // true
    }
}