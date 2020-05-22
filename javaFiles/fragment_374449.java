package de.scrum_master.aspect;

import de.scrum_master.app.ClassMarker;
import de.scrum_master.app.InterfaceMarker;
import de.scrum_master.app.MethodMarker;

public aspect MarkedObjectLogger {
    before() : @annotation(InterfaceMarker) {
        System.out.println(thisJoinPoint + " -> @InterfaceMarker");
    }

    before() : @annotation(ClassMarker) {
        System.out.println(thisJoinPoint + " -> @ClassMarker");
    }

    before() : @annotation(MethodMarker) && execution(* *(..)) {
        System.out.println(thisJoinPoint + " -> @MethodMarker");
    }
}