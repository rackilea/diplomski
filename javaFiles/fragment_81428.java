class OuterClass {
    // ...
    void method() {
        Thread t = new Thread(new Runnable() { 
            // ... code implementing Runnable interface ... 
        });
        // ... code to use t or whatever
    }
}