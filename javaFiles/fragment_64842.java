@around(value="execution(* package.name.class.Tag.of)")
public void wrapTags(ProceedingJoinPoint call){
   try {
     Object[] args = call.getArgs();
     // wrap args in Optional.ofNullable
     call.proceed();
   } catch (Exception e){
      // handle exception
   }
}