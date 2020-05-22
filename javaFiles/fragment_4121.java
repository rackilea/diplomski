@Before("execution(* com.my_aop_example.HumanFactory.*(..))")
  public void logBefore(JoinPoint joinPoint) {

    System.out.println("Log before start");
    System.out.println("Name: " + joinPoint.getSignature().getName());
    System.out.println("Log before end");

  }