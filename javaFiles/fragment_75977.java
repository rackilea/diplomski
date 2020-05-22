@Override
public void onReceive(Context context, Intent intent) {
    if (intent != null) {
        if (intent.getAction().equals(ACTION_BUTTON_REFRESH)) {
           //make some logic here on button refresh
        } else if (intent.getAction().equals(ACTION_BUTTON_SHARE)) {
           //make some logic here on button share
        } else {
           super.onReceive(context, intent);
        }
    }
}