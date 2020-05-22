public void foo(MyClassA paraA) {
    block: {
        if (paraA == null) { break block; }
        MyClassB paraB = doSomeStuff(paraA);
        if (paraB == null) { break block; }
        MyClassC paraC = doMoreStuff(paraB);
        if (paraC == null) { break block; }
        ...
        return;
    }

    doLog();
}