public class Estragon {
  public static class Vladimir {
    Vladimir() { System.out.println("Open"); }
    public void close() { System.out.println("Close");}
  }

  private static ThreadLocal<Vladimir> HOLDER = new ThreadLocal<Vladimir>() {
    @Override protected Vladimir initialValue() {
      return createResource();
    }
  };

  private static Vladimir createResource() {
    final Vladimir resource = new Vladimir();
    final Thread godot = Thread.currentThread();
    new Thread() {
      @Override public void run() {
        try {
          godot.join();
        } catch (InterruptedException e) {
          // thread dying; ignore
        } finally {
          resource.close();
        }
      }
    }.start();
    return resource;
  }

  public static Vladimir getResource() {
    return HOLDER.get();
  }
}