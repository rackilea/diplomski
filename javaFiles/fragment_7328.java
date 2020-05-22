@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();

    // not legal in Java, through at least JDK 10:
    public static int strlen(java.lang.String str) {
        return str.length(); // boring!
    }
}