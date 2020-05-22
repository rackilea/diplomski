public aspect intLogin {
  private capture c = new capture();
  pointcut login(Object a) : call(public * login(..)) && (target(a)) && this(capture);
  before (Object x):login( spring.aop.so_52992365.intLogin) {
    String xString = x.toString();
    System.out.println("The class that is calling the function is:" + thisJoinPoint.getSourceLocation());
    c.print();
  }
}