package de.scrum_master.aspect;

import de.scrum_master.app.Trace;
import de.scrum_master.app.TraceAll;

public aspect TraceAspect {
  before() : @target(TraceAll) && execution(* *(..)) {
    System.out.println(thisJoinPoint);
  }

  before() : @annotation(Trace) && execution(* *(..)) {
    System.out.println(thisJoinPoint);
  }

  declare error : execution(@Trace * (@TraceAll *).*(..))
    : "Don't combine @TraceAll and @Trace annotations"; 
}