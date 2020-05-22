public class ApiProxyHook<E extends Environment> implements Delegate<E> {
  private Delegate<E> baseDelegate;
  ... 

  @Override
  public byte[] makeSyncCall(E environment, String pkg, String method, byte[] request)
      throws ApiProxy.ApiProxyException {
    byte[] response = this.baseDelegate.makeSyncCall(environment, pkg, method, request);

    examineRequest(pkg, method, request);
    examineResponse(pkg, method, response);

    return response;
  }
  ... 

  @Override
  public Future<byte[]> makeAsyncCall(E env, final String pkg, final String method, byte[] request, ApiConfig apiConfig) {

    examineRequest(pkg, method, request);

    Future<byte[]> innerFuture = baseDelegate.makeAsyncCall(env, pkg, method, request, apiConfig);
    return new HookedFuture<byte[]>(innerFuture) {
      @Override
      protected void futureResultIs(byte[] response) {

        examineResponse(pkg, method, response);

      }
    };

  }
  ... 
}