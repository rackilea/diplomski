interface Argument<R> {
    // Empty interface used to mark argument types.
}

interface Invokable<R, A extends Argument<R>> extends FunctionalInterface {
    R invoke(A argument);
}