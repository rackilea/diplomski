public class GCMIntentService extends GCMBaseIntentService {
    @Override
    protected void onMessage(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String sender = extras.getString("sender");
        String message = extras.getString("message");

        ConversationModel model = new ConversationModel(context);
        model.open();
        model.createMessage(sender, message.trim(), true, true, ConversationMessage.STATUS_SENT);
        model.close();

        // if ConversationActivity is active, send a message to handler to refresh the conversation
        if(ActiveMessageHandler.instance().getActivity() != null)
        {
            Message msg = Message.obtain(ActiveMessageHandler.instance());
            msg.obj = "gcmNewMessage";
            ActiveMessageHandler.instance().sendMessage(msg);

            // Optionally, play a notification sound
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        }
        else
            createMessageNotification(context, sender, message);
    }
}