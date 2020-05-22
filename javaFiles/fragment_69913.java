package de.scrum_master.aspect;

import de.scrum_master.app.Foo;

public aspect MyAspect {
  pointcut pcmethodA() : call(* Foo.methodA(..));

  before() : pcmethodA() {
    System.out.println("[AspectJ] Executing: " + thisJoinPoint);
    System.out.println("[AspectJ] Called by: " + thisEnclosingJoinPointStaticPart);
  }
}