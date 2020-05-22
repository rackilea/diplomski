public void method1() {
   withLock(() -> { 
           /** your method1 code here **/
       }
   );
}

private void withLock(Consumer<T> consumer) {
    LOCK.lock();
    try {
        consumer.accept();
    } finally {
        LOCK.unlock();
    }
}