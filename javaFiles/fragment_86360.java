Runnable[] calls = {
        () -> callMethodA(),
        () -> callMethodB(),
        // ...
};

for (int i = 0; i < 5; i++) {
    for (Runnable runnable : calls) {
        runnable.run();
        Thread.sleep(1000);
    }
}