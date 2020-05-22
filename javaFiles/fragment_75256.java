public class Person {
    public String name;
}

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    Person person();
}

@MyAnnotation(person = ???) // how to guarantee it won't change at runtime?
public void method1()  {...}