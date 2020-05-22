@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface InHouse {

    public Class[] parentClassNames() default {};
}

public class Person{

    @InHouse(parentClassNames={Integer.class, String.class}) //Integer and String 
//are just as example, i know they are final and cant be parent classes :)
    public Contact contact;
}