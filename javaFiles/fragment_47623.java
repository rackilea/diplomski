// Untested, Java pseudocode...
public void awaitAllRemoteCalls() {
    final CountDownLatch allDoneSignal = new CountDownLatch(N);
    // For each remote N calls...
    thirdPartyAsyncCall.call(new AsyncHandler(Object remoteData) {
        // Handle the remote data...
        allDoneSignal.countDown();
    });
    allDoneSignal.await();
}