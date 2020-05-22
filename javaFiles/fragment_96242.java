Semaphore s = new Semaphore(40);
...
s.acquire();
try {
    dispatcher.dispatchRpcRequest(); // Or whatever your remote call looks like
} finally {
    s.release();
}