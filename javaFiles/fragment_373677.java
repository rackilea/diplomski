private boolean defaultOptionalFlagValue = true;

public void doSomething(boolean optionalFlag) {
    ...
}

public void doSomething() {
    doSomething(defaultOptionalFlagValue);
}