package de.scrum_master.aop;

public aspect AccessController_Common extends AccessController {
    pointcut ownPackage() :
        within(de.scrum_master.common..*);

    pointcut ownPackageCall() :
        call(* de.scrum_master.common..*(..)) || call(de.scrum_master.common..new(..));
}