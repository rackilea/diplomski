@AroundInvoke
   public Object myConstraintViolationInterceptor(InvocationContext ctx) throws Exception
   {
      try {
          return ctx.proceed();
      }
      catch(PersistenceException e) {
          if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
              //some action taken
          }
          else {
              throw e;
          }
          return null;
      }
   }