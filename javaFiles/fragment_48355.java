public <T extends Transformation> Object doSomething(Object obj, Class<T> transClass)
    throws Exception {
    // do more stuff to obj
    Transformation trans = transClass.newInstance();
    return trans.transform(obj);
}