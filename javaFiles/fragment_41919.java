pointcut profiledOperation(Profiled p) : 
      execution(@Profiled * *()) && @annotation(p);

   before(Profiled p): profiledOperation(p)
   {
      System.out.println("Before " + p.value());
   }

   after(Profiled p): profiledOperation(p)
   {
      System.out.println("After " + p.value());
   }