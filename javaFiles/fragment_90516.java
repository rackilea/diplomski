package de.scrum_master.aspect;

public aspect MyAspect {
  after() : call(* *(..)) && !within(MyAspect) {
    System.out.println(thisJoinPoint);
  }
}