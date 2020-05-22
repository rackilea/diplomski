@Retryable(value = {StaleStateException.class})
public void retryableUpdate() {
   updateA();
}

@Transactional(rollbackFor = {StaleStateException.class})
public void updateA() {
    A a = findA();
    B b = new B();
    // Update "a" somehow
    a.update();
    // "b" is saved on each retry!
    save(b);
}