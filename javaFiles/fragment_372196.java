@Aspect  
public class Clear 
{
   @After("@annotation(org.springframework.transaction.annotation.Transactional)")  
   public void clear(final JoinPoint joinPoint)  
   {  
      final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
      final Transactional txAnnotation = methood.getAnnotation(Transactional.class);
      final boolean isReadOnly = txAnnotation.readOnly();

      //do conditional work based on isReadOnly
   }
}