public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Bar.class.isAnnotationPresent(InheritedAnnotation.class));
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Inherited
@interface InheritedAnnotation {
}

@InheritedAnnotation
class Foo {

}

class Bar extends Foo {
}