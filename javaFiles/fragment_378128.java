public class Messages {
private Activity activity;
public Message(Activity activity){
    this.activity = activity;
}

public void SendAlert(String messageText) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    AlertDialog dlg = builder.setMessage(messageText).create();
    dlg.setOwnerActivity(activity);
    dlg.show();
}