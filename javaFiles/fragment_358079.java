public class RemoveControlWidget extends RemoteViews
{
private final Context mContext;

public static final String ACTION_PLAY = "com.mediabook.app.ACTION_PLAY";

public static final String ACTION_PREVIOUS = "com.mediabook.app.ACTION_PREVIOUS";

public static final String ACTION_NEXT = "com.mediabook.app.ACTION_NEXT";

public RemoveControlWidget(Context context , String packageName, int layoutId)
{
    super(packageName, layoutId);
    mContext = context;
    Intent intent = new Intent(ACTION_PLAY);
    PendingIntent pendingIntent = PendingIntent.getService(mContext.getApplicationContext(),100,
            intent,PendingIntent.FLAG_UPDATE_CURRENT);
    setOnClickPendingIntent(R.id.play_control,pendingIntent);
    setOnClickPendingIntent(R.id.pause_control,pendingIntent);
    intent = new Intent(ACTION_PREVIOUS);
    pendingIntent = PendingIntent.getService(mContext.getApplicationContext(),101,
            intent,PendingIntent.FLAG_UPDATE_CURRENT);
    setOnClickPendingIntent(R.id.previous_control,pendingIntent);
    intent = new Intent(ACTION_NEXT);
    pendingIntent = PendingIntent.getService(mContext.getApplicationContext(),102,
            intent,PendingIntent.FLAG_UPDATE_CURRENT);
    setOnClickPendingIntent(R.id.next_control,pendingIntent);
}
}