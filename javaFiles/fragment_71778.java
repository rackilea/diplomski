public class ConversationActivity extends Activity {
  @Override
  public void onStart() {
    super.onStart();
    ActiveMessageHandler.instance().setActivity(this);
  }

  @Override
  public void onStop() {
    super.onStop();
    ActiveMessageHandler.instance().setActivity(null);
  }
}