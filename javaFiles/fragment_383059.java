public class CallLogActivity extends Activity {


TextView textView;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_call_log);
    textView = (TextView) findViewById(R.id.textCallBetween);
    textView.setVisibility(View.GONE);
   // listcallLog = (ListView) findViewById(R.id.calllogItems);

    getCalldetails();


}

public void getCalldetails() {
    StringBuffer stringBuffer = new StringBuffer();

    String strOrder = android.provider.CallLog.Calls.DATE + " DESC";

    Calendar calender = Calendar.getInstance();


    calender.set(2016, calender.NOVEMBER, 18);
    String fromDate = String.valueOf(calender.getTimeInMillis());

    calender.set(2016, calender.NOVEMBER, 20);
    String toDate = String.valueOf(calender.getTimeInMillis());

    String[] whereValue = {fromDate,toDate};


    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return;
    }
    Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, android.provider.CallLog.Calls.DATE + " BETWEEN ? AND ?", whereValue, strOrder);

//   Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, android.provider.CallLog.Calls.DATE, new String[]{" BETWEEN ? AND ?"}, strOrder);
    int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
    int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
    int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
    int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);

    stringBuffer.append("Call Log :");

    while (managedCursor.moveToNext())
    {
        String phoneNumber = managedCursor.getString(number);
        String callType = managedCursor.getString(type);
        String callDate = managedCursor.getString(date);
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd-MMM-yyyy HH:mm");
        String dateString = formatter.format(new Date(Long
                .parseLong(callDate)));
      //  Date callDayTime = new Date(Long.valueOf(callDate));
        String callDuration = managedCursor.getString(duration);



        String dir = null;

        int dirCode = Integer.parseInt(callType);



        switch (dirCode)
        {
            case CallLog.Calls.OUTGOING_TYPE :
                dir = "OUTGOING";
                break;

            case CallLog.Calls.INCOMING_TYPE:
                dir = "INCOMMING";
                break;
            case CallLog.Calls.MISSED_TYPE:
                dir = "MISSED CALL";
                break;

        }

        stringBuffer.append("\nPhone Number:--- " + phoneNumber + "\nCall Type:--- "
                + dir + "\nCall Date:---"
                + dateString + "\nCall Duration:---" + callDuration);
        stringBuffer.append("\n--------------------------");

    }

    textView.setText(stringBuffer);
    textView.setVisibility(View.VISIBLE);

}