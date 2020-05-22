@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
    String value();
}

package com.test

@Controller("mainController")
public class Main {

    public static void main(String[] args) {
        AnnotatedClassProvider provider = Providers.newBased("com.test");
        Map<Class<?>, Controller> classes = provider.get(Controller.class);

        classes.forEach((x, y ) -> System.out.println(String.format("Class: %s annotated with %s with value %s",
                x.getName(), y.getClass().getName(), y.value())));
    }
}