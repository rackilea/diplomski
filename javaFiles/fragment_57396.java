public void someMethod() {
    @SomeAnnotation
    Test test;
}

@Target(value = { ElementType.LOCAL_VARIABLE })
public @interface SomeAnnotation {

}