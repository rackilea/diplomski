@AroundInvoke
public Object logInvocation(InvocationContext ctx) throws Exception {
   String class = ctx.getMethod().getDeclaringClass().getName();
   String method = ctx.getMethod().getName();
   Logger.global.entering(class, method, ctx.getParameters());
   try {
      Object result = ctx.proceed();
      Logger.global.exiting(class, method, result);
      return result;
   }
   catch (Exception e) {
      Logger.global.throwing(class, method, e);
      throw e;
   }

}