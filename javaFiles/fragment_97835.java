public void sayHello() {
    System.out.println("Hello World!");
    //How to pass argument to afterAdvice
    this.arg = ...;
}

@After("doSomething()")             
public void afterAdvice(JoinPoint jp) {
    System.out.println("After Advice");
    Employee emp = (Employee) jp.getTarget();
    // use emp.arg here ...
}