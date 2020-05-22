public class MyLazyPanel2 extends LazyPanel {
  Label l = new Label("label2");
  @Override
  protected Widget createWidget() {
    System.out.println("now2");
    return l;
  }
}