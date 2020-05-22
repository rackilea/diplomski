package de.scrum_master.aspect;

public aspect MyAspect {
  after() : execution(* *(..)) {
    System.out.println(thisJoinPoint);
  }
}