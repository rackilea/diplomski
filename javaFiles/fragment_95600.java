public void bar() {
    if (threadLocal == null) {
        threadLocal.set(new Context(recursiveSpecificSet));
    }
    threadLocal.get().increaseDepth();

    try {
        ...
        methodCallThatCallsBar(...);
        ...
    }
    finally {
        threadLocal.get().decreaseDepth();
        if (threadLocal.get().isExitRecursion()) {
            threadLocal.remove();
        }
    }
}