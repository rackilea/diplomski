public void throwsUndeclaredCheckedException() {
    // compiler error because this exception is not declared (and not caught)
    throw new Exception();
}

public void throwsDeclaredCheckedException() throws Exception {
    // okay, because it was declared
    throw new Exception();
}

public void catchesUndeclaredCheckedException() {
    try {
        throw new Exception();
    } catch( Exception ignored ) {
        // the thrown exception is caught and now ignored, hence the method
        // can't throw and we don't need to declare anything
    }
}

public void throwsUndeclaredRuntimeException() {
    // okay, because it's an unchecked exception
    throw new RuntimeException();
}

public void throwsDeclaredRuntimeException() throws RuntimeException {
    // works, but the "throws" declaration on the method is unnecessary
    throw new RuntimeException();
}