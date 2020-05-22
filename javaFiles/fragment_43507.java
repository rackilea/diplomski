ListenableFuture<ProcessedRequest> future = asyncService.processVlan(id, name);

future.addCallback(new ListenableFutureCallback<ProcessedRequest>() {
        @Override
        public void onFailure(Throwable throwable) {
          // deal with it
        }
        @Override
        public void onSuccess(ProcessedRequest processedRequest) {
            processedRequestRepository.save(processedRequest);
        }
    });