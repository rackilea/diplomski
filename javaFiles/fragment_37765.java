// ideal solution, not possible without redesign

@Override public static void someMethod() throws CustomException {
    throw new CustomException();
}

//...
try {
    someMethod();
} catch (CustomException e) {
    handleCustomException(e);
}