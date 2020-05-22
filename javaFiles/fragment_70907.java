public MyException getDeepestException(MyException e) {
    Throwable t = e.getCause();
    if (t instanceof MyException) {
        return getDeepestException((MyException)t);
    }
    return e;
}