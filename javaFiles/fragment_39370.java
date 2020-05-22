import java.lang.reflect.InvocationTargetException;

// IMPORTANT: parameter exClass must have at least no args constructor and constructor with String param
public class Precondition {

public static <T extends Exception> void checkArgument(boolean expression, Class<T> exClass) throws T {
    checkArgument(expression, exClass, null);
}

public static <T extends Exception> void checkArgument(boolean expression, Class<T> exClass, String errorMessage, Object... args) throws T {
    if (!expression) {
        generateException(exClass, errorMessage, args);
    }
}

public static <T extends Exception> void checkNotNull(Object reference, Class<T> exClass) throws T {
    checkNotNull(reference, exClass, null);
}

public static <T extends Exception> void checkNotNull(Object reference, Class<T> exClass, String errorMessage, Object... args) throws T {
    if (reference == null) {
        generateException(exClass, errorMessage, args);
    }
}

private static <T extends Exception> void generateException(Class<T> exClass, String errorMessage, Object... args) throws T {
    try {
        if (errorMessage == null) {
            throw exClass.newInstance();
        } else {
            throw exClass.getDeclaredConstructor(String.class, Object[].class).newInstance(errorMessage, args);
        }
    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
    }
}