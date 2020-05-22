try {
    while(!condition) {
       wait();
    }
    doSomething();
} catch(InterruptedException e) {
    doSomethingElseWhenWeAreAskedNotToWait();
}