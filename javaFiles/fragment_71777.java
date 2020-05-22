public class ActiveMessageHandler extends Handler {

  private static ActiveMessageHandler _instance = new ActiveMessageHandler();
  private Activity _activity = null;

  @Override
  public void handleMessage(Message message) {
    if(message.obj.toString().equals("gcmNewMessage") && _activity != null)
        ((ConversationActivity)_activity).repopulateList();

    super.handleMessage(message);
  }

  public static ActiveMessageHandler instance() {
    return _instance;
  }

  public void setActivity(Activity activity) {
    _activity = activity;
  }

  public Activity getActivity() {
    return _activity;
  }

}