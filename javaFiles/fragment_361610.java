public void getCallLog() {

    String[] callLogFields = { android.provider.CallLog.Calls._ID,
            android.provider.CallLog.Calls.NUMBER,
            android.provider.CallLog.Calls.CACHED_NAME /* im not using the name but you can*/};
    String viaOrder = android.provider.CallLog.Calls.DATE + " DESC";
    String WHERE = android.provider.CallLog.Calls.NUMBER + " >0"; /*filter out private/unknown numbers */

    final Cursor callLog_cursor = getActivity().getContentResolver().query(
            android.provider.CallLog.Calls.CONTENT_URI, callLogFields,
            WHERE, null, viaOrder);

    AlertDialog.Builder myversionOfCallLog = new AlertDialog.Builder(
            getActivity());

    android.content.DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int item) {
            callLog_cursor.moveToPosition(item);

            Log.v("number", callLog_cursor.getString(callLog_cursor
                    .getColumnIndex(android.provider.CallLog.Calls.NUMBER)));

            callLog_cursor.close();

        }
    };
    myversionOfCallLog.setCursor(callLog_cursor, listener,
            android.provider.CallLog.Calls.NUMBER);
    myversionOfCallLog.setTitle("Choose from Call Log");
    myversionOfCallLog.create().show();
}