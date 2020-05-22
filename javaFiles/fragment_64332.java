retrofitService.getSomething()
    .flatMap(firstResponse -> retrofitService.getSecondResponse(firstResponse.id)
    .subscribeWith(new DisposableSingleObserver<SecondResponse>() {
         @Override
         public void onSuccess(final SecondResponse secondResponse) {
            // we're done with both!
         }

         @Override
          public void onError(final Throwable error) {
             // a request request Failed, 
          }                        
   });