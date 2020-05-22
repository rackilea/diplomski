pointcut myPointcut(String someString):
    execution (public void myMethod(String, String, String, String, String, String)) &&
    target(MyClass) &&
    args(someString);

after(String someString) : myPointcut(someString) {

}