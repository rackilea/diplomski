Future future = aExecutorService.submit(new Runnable() {
    @Override
    public void run() {
        try {
            final T aresult = aCallable.call();
            sendSuccessMesage(aResult);
        } catch(Throwable e)
            sendExceptionHappenedMessage(e.getMessage());
        }
    }
});

// to cancel.
future.cancel(true);