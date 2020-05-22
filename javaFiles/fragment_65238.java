public class OkHttpResponseFuture implements Callback {
  public final CompletableFuture<Response> future = new CompletableFuture<>();

  public OkHttpResponseFuture() {
  }

  @Override public void onFailure(Call call, IOException e) {
    future.completeExceptionally(e);
  }

  @Override public void onResponse(Call call, Response response) throws IOException {
    future.complete(response);
  }
}