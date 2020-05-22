public void foo(MyInterface para) {
    while (para != null) {
        para = para.doStuff();
    }
    doLog();
}