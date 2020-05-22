JavaClass javaClass = Repository.lookupClass("ExampleClassFile");
for(Method method: javaClass.getMethods()){
    for(LocalVariable localVariable: method.getLocalVariableTable().getLocalVariableTable()){
        System.out.println(Utility.signatureToString(localVariable.getSignature()) + " " + localVariable.getName());
    }
}