// issuing requests
while (haveRequests) {
    MessageRequest request = mkRequest();
    this.requestObserver.onNext(request);
    this.inFlight++; 
}
requestObserver.onCompleted();