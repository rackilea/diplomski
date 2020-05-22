final Semaphore semaphore = new Semaphore(maxConcurrencyLevel);
for (int i = 0; i < n; i++) {

    semaphore.acquire();
    this.httpclient.execute(
            new BasicAsyncRequestProducer(target, request),
            new MyResponseConsumer(),
            new FutureCallback<HttpResponse>() {

                @Override
                public void completed(final HttpResponse result) {
                    semaphore.release();
                }

                @Override
                public void failed(final Exception ex) {
                    semaphore.release();
                }

                @Override
                public void cancelled() {
                    semaphore.release();
                }

            });
}