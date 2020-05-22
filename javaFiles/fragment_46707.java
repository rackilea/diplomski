import java.lang.reflect.*;
import java.util.*;

public class Test {

    public void foo(LinkedList<Integer> intList) {
    }

    public static void main(String[] args) throws Exception {
        Method method = Test.class.getMethod("foo", LinkedList.class);
        Type[] parameters = method.getGenericParameterTypes();
        System.out.println(parameters[0]);
    }
}