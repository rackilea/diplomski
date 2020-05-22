import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class ReflectiveGetter {
    private final Object theObject;
    private final String methodPattern;
    private final Map<Integer, Method> methodsByIndex = new HashMap<Integer, Method>();

    public ReflectiveGetter(Object theObject, String methodPattern) {
        this.theObject = theObject;
        this.methodPattern = methodPattern;

        String patternToMatch = methodPattern + "\\d+";
        for(Method m : theObject.getClass().getMethods()) {
            String name = m.getName();

            if(name.matches(patternToMatch)) {
                m.setAccessible(true);
                int i = Integer.parseInt(name.substring(methodPattern.length()));
                methodsByIndex.put(i, m);
            }
        }
    }

    public int getValue(int index)
    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method m = methodsByIndex.get(index);

        if(m != null) {
            return (Integer)m.invoke(theObject);
        }

        throw new NoSuchMethodException(methodPattern + index);
    }
}