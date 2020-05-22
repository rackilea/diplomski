public <T> List<T> doSomething(Class<T> clazz, String aString, Integer anInteger) {
    List<T> listOfClassObjects;
    if(condition) {
        Constructor<T> constructor = clazz.getConstructor(String.class, Integer.class);
        aClassInstanceVariable = constructor.newInstance(aString, anInteger);
    }
    else {
        aClassInstanceVariable = getClassTInstanceVariableFromSomewhere();
    }
    listOfClassObjects.add(aClassInstanceVariable);
    return listOfClassObjects;
}