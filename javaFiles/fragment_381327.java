package de.scrum_master.aop;

public abstract aspect AccessController {
    // All method/constructor calls to base package
    pointcut basePackageCall():
        call(* de.scrum_master..*.*(..)) || call(de.scrum_master..*.new(..));

    // Method/constructor calls to public packages
    pointcut publicPackageCall() :
        call(* de.scrum_master..*.pub..*(..)) || call(de.scrum_master..*.pub..new(..));

    // Own "major" package. Please override in concrete sub-aspect like this:
    // within(de.scrum_master.mymajor..*) 
    pointcut ownPackage();

    // Method/constructor calls within own "major" package. Please override in concrete sub-aspect like this:
    // call(* de.scrum_master.mymajor..*(..)) || call(de.scrum_master.mymajor..new(..)) 
    pointcut ownPackageCall();

    pointcut forbiddenCall() :
        ownPackage() && basePackageCall() && !(publicPackageCall() || ownPackageCall());

    declare error: forbiddenCall() :
        "Illegal call to non-public foreign major package";
}