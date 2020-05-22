public class MyLazyPanel1 extends LazyPanel {
  Label l = new Label("label1");
  @Override
  protected Widget createWidget() {
    System.out.println("now1");
    return l;
  }
}