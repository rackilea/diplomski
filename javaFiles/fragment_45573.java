@Resource(name = "foo", description = "bar")
public class Test {

    public static void main(String[] args) throws Exception {

        for (Annotation annotation : Test.class.getAnnotations()) {
            Class<? extends Annotation> type = annotation.annotationType();
            System.out.println("Values of " + type.getName());

            for (Method method : type.getDeclaredMethods()) {
                Object value = method.invoke(annotation, (Object[])null);
                System.out.println(" " + method.getName() + ": " + value);
            }
        }

    }
}