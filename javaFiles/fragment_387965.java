/** Interceptor that validates user's identity. */
class MyAuthInterceptor implements ServerInterceptor {
  public static final Context.Key<Object> USER_IDENTITY
      = Context.key("identity"); // "identity" is just for debugging

  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
      ServerCall<ReqT, RespT> call,
      Metadata headers,
      ServerCallHandler<ReqT, RespT> next) {
    // You need to implement validateIdentity
    Object identity = validateIdentity(headers);
    if (identity == null) { // this is optional, depending on your needs
      // Assume user not authenticated
      call.close(Status.UNAUTENTICATED.withDescription("some more info"),
                 new Metadata());
      return new ServerCall.Listener() {};
    }
    Context context = Context.current().withValue(USER_IDENTITY, identity);
    return Contexts.interceptCall(context, call, headers, next);
  }
}

public class TestImpl extends TestServiceGrpc.TestServiceImplBase {
  @Override
  public void testHello(TestRequest req, StreamObserver<TestResponse> responseObserver) {
    // Access to identity.
    Object identity = MyAuthInterceptor.USER_IDENTITY.get();
    ...
  }
}

// Need to use ServerInterceptors to enable the interceptor
Server server = ServerBuilder.forPort(PORT)
    .addService(ServerInterceptors.intercept(new TestImpl(),
        new MyAuthInterceptor()))
    .build()
    .start();