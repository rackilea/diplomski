public class SomeClass {
  // AtomicBolean defaults to the value false.
  private AtomicBoolean loadingResource = new AtomicBoolean();
  private volatile Object resource;

  public void handleDrawRequest(Canvas canvas) {
    if (resource == null) {
      if (loadingResource.compareAndSet(false, true)) {
        loadTheResource();  //which takes awhile
      } else {
        //another thread is taking care of the loading of the resource
        //and its not ready yet, so just ignore this request
        return;  
      }
    } else {
      drawResourceOn(canvas);
    }
  }
}