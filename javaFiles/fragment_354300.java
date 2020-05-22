StreamObserver<SubscribeTradesResponse>  tradeObserver= response -> 
      responseOnNextAction(response);
//or
StreamObserver<SubscribeTradesResponse>  tradeObserver= 
      this::responseOnNextAction;

StreamObserver<SubscribeOrderResponse> orderObserver = response -> 
      responseOnNextAction(response);
//or
StreamObserver<SubscribeOrderResponse> orderObserver = 
      this::responseOnNextAction;