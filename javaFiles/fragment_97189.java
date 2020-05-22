public class ExitInterceptor implements MethodInterceptor {

 @Override
 public Object invoke(MethodInvocation methodInvocation) throws Throwable {
  try {
   return methodInvocation.proceed();
  } catch (NoClassDefFoundError noClassDefFoundError) {
   noClassDefFoundError.printStackTrace();
   System.exit(1);
   return null;
  }
 }

}