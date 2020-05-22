try {

} catch (NullPointerException e) {
    throw new MyException("My exception message", e);
    or
    throw new MyException("My exception message");
    or
    throw new MyException(e);
}