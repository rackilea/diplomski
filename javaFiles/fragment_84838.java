// both write and listener threads will need to share this
  private final AtomicReference<Response> responseRef =
     new AtomicReference<Response>();
  ...
  // writer-thread
  writeRequest(request);
  synchronize (responseRef) {
     while (responseRef.get() == null) {
        // maybe put a timeout here
        responseRef.wait();
     }
  }
  processResponse(response);
  ...

  // listener-thread
  Response response = readResponse();
  synchronize (responseRef) {
     responseRef.set(response);
     responseRef.notify();
  }