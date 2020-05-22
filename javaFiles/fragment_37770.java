@Override
public void onReceive(Context context, Intent intent)
{
    String action = intent.getAction();

    if(action.equals(ACTION_MESSAGE_RECEIVED)) {
        ...
    }
    else if(action.equals(ACTION_OTHER)) {
        ...
    }
    ...
}