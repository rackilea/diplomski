public MyClass

    void myMethod(Function<MyClass, Void> onCompletion) {
        try {
            // Do stuff
        } finally {
            onCompletion.apply(this);
        }
    }