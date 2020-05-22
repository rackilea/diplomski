public Either<Exception, Result> meaningfulMethod(Value val) {
    try {
       return Either.right(methodThatMightThrow(val));
    } catch (Exception e) {
       return Either.left(e);
    }
}