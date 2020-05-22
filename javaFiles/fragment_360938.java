try {
    doSomethingDangerous();
} catch (Throwable t) {
    if (t instanceof IOException) {
        handleIoException(t);
    } else if (...) {
        ...
    } else {
        handleOther(t);
    }
}