public void someMethod() throws ExcpetionB {
    try {
        // some code that may throw ExceptionA
    }
    catch (ExceptionA excA) {
        throw new ExceptionB ("some message", excA);
    }
}