package de.scrum_master.aspect;

public aspect MyAspect {
    before() : execution(* *(..)) && @annotation(Marker) {
        System.out.println(thisJoinPoint);
    }
}