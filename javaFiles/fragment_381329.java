package de.scrum_master.aop;

public aspect AccessController_Feature1 extends AccessController {
    pointcut ownPackage() :
        within(de.scrum_master.feature1..*);

    pointcut ownPackageCall() :
        call(* de.scrum_master.feature1..*(..)) || call(de.scrum_master.feature1..new(..));
}