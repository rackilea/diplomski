package de.scrum_master.aop;

public aspect AccessController_Feature2 extends AccessController {
    pointcut ownPackage() :
        within(de.scrum_master.feature2..*);

    pointcut ownPackageCall() :
        call(* de.scrum_master.feature2..*(..)) || call(de.scrum_master.feature2..new(..));
}