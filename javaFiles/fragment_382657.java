@Pointcut("execution(private * *(..))")
 public void anyPrivateMethod() {}

 @Before("anyPrivateMethod()")
 public void beforePrivateMethod(JoinPoint jp) {
     System.out.println("Before a private method...");
 }