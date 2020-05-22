package de.scrum_master.aspect;

import de.scrum_master.app.Trace;

public aspect TraceAspect {
  before() : (@target(Trace) || @annotation(Trace)) && execution(* *(..)) {
    System.out.println(thisJoinPoint);
  }
}