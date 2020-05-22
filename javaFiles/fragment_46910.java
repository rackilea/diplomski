private double[] doStuffWithFoo(Foo1 foo) {
    double[] array = getArrayFromFoo1(foo);
    doCommonStuff(array);
    return array;
}


private double[] doStuffWithFoo(Foo2 foo) {
    double[] array = getArrayFromFoo2(foo);
    doCommonStuff(array);
    return array;
}

private void doCommonStuff(double[] array) {
    // common stuff
}