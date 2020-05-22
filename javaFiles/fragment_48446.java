private void setValuePrivate(String arg1) {
    Fragment frag1 = foundElem(arg1);
    // ... do something with frag1, do something else
}

public void setValue(String arg1) {
    setValuePrivate(arg1);
    doSomething();
}

public void setValue(String arg1, String arg2) {
    setValuePrivate(arg1);
    doSomething(arg2);
}