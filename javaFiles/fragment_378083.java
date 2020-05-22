@Qualifier
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface SquaredString {}

public class Formatter {

    @SquaredString// you can also use @Named, this is just as an example
    public static Integer squaredString(String obj) {
        return toSquare(toInteger(obj));
    }
    //your other methods are here as well
}