package de.scrum_master.aspect;

public aspect MetaAspect {
  before() : adviceexecution() && !within(MetaAspect) {
    System.out.println(thisJoinPoint);
  }
}