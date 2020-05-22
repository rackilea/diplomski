import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestReflection extends AbstractCollection<String> {

    private List<Integer> childCollection = new ArrayList<Integer>();


    public List<Integer> getChildCollection() {
        return childCollection;
    }

    public static void main(final String[] args) throws Exception {
        final TestReflection testReflection = new TestReflection();

        final Class<?> cls = testReflection.getClass();
        Method method1 = cls.getMethod("getChildCollection", new Class[] {});
        System.out.println(method1.getGenericReturnType());

        Method method2 = cls.getMethod("getCollection", new Class[] {});
        System.out.println(method2.getGenericReturnType());
   }

}