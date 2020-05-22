} catch (InterruptedException e) {
    // resets the interrupt flag cleared by catching the exception
    Thread.currentThread.interrupt();
    // or stops the thread immediately
    return;
}