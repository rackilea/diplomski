public MyType doSomething(...) {
    MyType myType = ........
    if (myType == null) {
        final String message = "...";
        throw logErrorAndThrowRuntimeException(message);
    }
    return myType;
}