final ExecutionContext ec = system.dispatcher();

future.onComplete(new OnComplete<VaderResponse>() {
  public void onComplete(Throwable failure, VaderResponse result) {
    if (failure != null) {
      // Derp
    } else {
      // Report acknowledged
    }
  }
}, ec);