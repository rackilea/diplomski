retrofitService.getSomething()
    .flatMap(new Func1<FirstResponse, Observable<SecondResponse> {
        public void Observable<SecondResponse> call(FirstResponse firstResponse) {
            return retrofitService.getSecondResponse(firstResponse.id)
        }
    })
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