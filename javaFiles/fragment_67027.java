@Target(value = {ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface ParamAnnotation {}

@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MethodAnnotation {}

abstract class T<A,B> {
    B m(A a){return null;}
 }

 class CovariantReturnType extends T<Integer, Integer> {
     @MethodAnnotation
     Integer m(@ParamAnnotation Integer i) {
         return i;
     }

    public class VisibilityChange extends CovariantReturnType {}

}