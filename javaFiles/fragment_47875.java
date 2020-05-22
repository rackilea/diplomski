Object around() : allMethods() {
    SomeObject foo = makeSomeObject();
    Object ret = proceed();
    foo.magic();
    return ret;
}