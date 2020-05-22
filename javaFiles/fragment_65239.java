OkHttpResponseFuture callback = new OkHttpResponseFuture();
  client.newCall(request).enqueue(callback);

  return callback.future.thenApply(response -> {
    try {
      return convertResponse(response);
    } catch (IOException e) {
      throw Throwables.propagate(e);
    } finally {
      response.close();
    }
  });