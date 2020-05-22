import java.lang.reflect.*;

public class Main {

    static Object invokeIfExists(Class<?> cls, String methodName,
                                 Class<?>[] argTypes,
                                 Object callingObject, Object[] args) {
        try {
            Method method = cls.getDeclaredMethod(methodName, argTypes);
            return method.invoke(callingObject, args);
        } catch (SecurityException | NoSuchMethodException e) {
            System.err.println("Method " + methodName + " not found.");
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.err.println("Method " + methodName + " could not be invoked.");
        } catch (InvocationTargetException e) {
            System.err.println("Method " + methodName + " threw an exception.");
        }
        return null; // Or assert false, etc.
    }

    public static void main(String[] args) {
        Direction direction = new Direction("a", "b");

        // Tries to invoke "direction.print(123)"
        String printResult = (String) invokeIfExists(
            Direction.class, "print", new Class<?>[]{int.class},
            direction, new Object[]{123});
        System.out.println(printResult); // "Direction: a -> b and foo=123"

        // Tries to invoke "direction.doesntExist()"
        Object doesntExistResult = invokeIfExists(
            Direction.class, "doesntExist", new Class<?>[]{},
            direction, new Object[]{});
        System.out.println(doesntExistResult); // null
    }
}

class Direction {
    private String from, to;

    Direction(String from, String to) {
        this.from = from;
        this.to = to;
    }

    String print(int foo) {
        return "Direction: " + from + " -> " + to + " and foo=" + foo;
    }
}