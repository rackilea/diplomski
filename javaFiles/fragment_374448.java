package de.scrum_master.aspect;

import de.scrum_master.app.ClassMarker;
import de.scrum_master.app.InterfaceMarker;
import de.scrum_master.app.MethodMarker;
import de.scrum_master.app.MyInterface;
import de.scrum_master.app.SpecialBase;

public aspect AnnotationGenerator {
    declare @type : MyInterface+ : @InterfaceMarker;
    declare @type : SpecialBase : @ClassMarker;
    declare @method : * say*(..) : @MethodMarker;
}