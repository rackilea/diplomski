@Aspect
     public class MyAspect {

    @Around("execution(* *(..)) && !within(MyAspect)")
       public Object aroundTest(ProceedingJoinPoint thisJoinPoint){
        Object retVal = null;
           try {
                myfunction(thisJoinPoint);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return retVal;
       }

       public void myfunction(ProceedingJoinPoint pjp) throws Throwable {
           System.out.println("Inside myfunction(): " + pjp.getSignature());
           pjp.proceed();
       }
     }