public class IncrementalDom {

  @JsMethod(namespace = "app.incrementaldom", name = "patch")
  public static native void patch(Element element, Patcher patcher);

  @JsFunction
  @FunctionalInterface
  public interface Patcher {
    void apply();
  }

}