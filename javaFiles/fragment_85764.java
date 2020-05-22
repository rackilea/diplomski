public class DialogOrder extends Dialog {

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    ...

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           listener.onButtonClicked();
           dismiss();
        }
    });
  }
}