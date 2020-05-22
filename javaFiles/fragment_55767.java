synchronized (Foo.class) {
    while (someCondition && !Thread.currentThread().isInterrupted()) {
        try {
            Foo.class.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();            
        }
    }
}