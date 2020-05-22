package de.scrum_master.aspect;

public aspect MyAspect {
  after() : call(* de.scrum_master.app..*(..)) && !within(MyAspect) {
    System.out.println(thisJoinPoint);
  }
}