public class Control {
  private View view;
  private Model model;

  public Control(View view, Model model) {
    this.view = view;
    this.model = model;
  }

  // now your control can call model and view methods.
  // ....
}