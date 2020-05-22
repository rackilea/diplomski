public class DialogOrder extends Dialog {
  ...
  Activity context;
  private DialogListener listener;

  public interface DialogListener {
    void onButtonClicked();
  }

  public DialogOrder(Activity context, DialogListener listener) {
    super(context);
    this.context = context;
    this.listener = listener;
  }

  ...

}