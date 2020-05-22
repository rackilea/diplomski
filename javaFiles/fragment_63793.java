private int deleteMessage(Context context, SmsMessage msg) {
    Uri deleteUri = Uri.parse("content://sms");
    int count = 0;
    Cursor c = context.getContentResolver().query(deleteUri, null, null,
            null, null);
    while (c.moveToNext()) {
        try {
            // Delete the SMS
            String pid = c.getString(0); // Get id;
            String uri = "content://sms/" + pid;
            count = context.getContentResolver().delete(Uri.parse(uri),
                    null, null);
        } catch (Exception e) {
        }
    }
    return count;
}