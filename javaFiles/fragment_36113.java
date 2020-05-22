public boolean myMethod(ClassA obj) {
    obj.setValue(...);
    return true;
}

...

ClassA objA = new ClassA();
if (myMethod(objA) {
   Object val = objA.getValue();
   ...
}