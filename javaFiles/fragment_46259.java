private Context contextic;    //    NEEDLEES !
@Override
public void onReceive(Context context, Intent intent) {
    // TODO Auto-generated method stub
    Calendar c = Calendar.getInstance();                
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    int sek = c.get(Calendar.SECOND);
    int dan;
    int dodaj;

    milivreme = ((hour * 60 * 60 * 1000)+ (minute * 60 * 1000) + (sek * 1000));

    Cursor cursor = DatabaseManager.getAllData();

    cursor.moveToFirst();
    if (!cursor.isAfterLast())
    {
        do
        {               
    milibaza = cursor.getInt(3);
    razlika = milibaza - milivreme;

    Intent intent1 = new Intent(context, AlarmReceiver.class);
    PendingIntent pendingintent = PendingIntent.getService(context, 2, intent1, PendingIntent.FLAG_CANCEL_CURRENT);
    AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE); //CONTEXT ! 

    am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + razlika, pendingintent);
        }
        while (cursor.moveToNext());
    }}