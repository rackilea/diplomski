for (...) {
    Method method = ...

    // this class calls method.invoke(..) inside its onEvent() method
    MethodIFunc mi = new MethodIFunc(method, set);
    MeasureAndRecord(name, mi);
}