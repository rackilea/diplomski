public Arg sayHello() {
    System.out.println("Hello World!");
    //How to pass argument to afterAdvice
    Arg arg = ...;
    return arg;
}

@AfterReturning(pointcut="doSomething()", returning="retval")             
public void afterAdvice(Object retval) {
    System.out.println("After Advice");
    // use retval here ...
}