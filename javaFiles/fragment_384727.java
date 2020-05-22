public class SmsObserver extends ContentObserver {
    private static final Handler handler = new Handler();
    private static final Uri uri = Uri.parse("content://sms/");

    private final Context context;
    private final ContentResolver resolver;
    private final String address;
    private final String body;

    public interface OnSmsSentListener {
        public void onSmsSent(int threadId);
    }

    public SmsObserver(Context context, String address, String body) {
        super(handler);

        if (context instanceof OnSmsSentListener) {
            this.context = context;
            this.resolver = context.getContentResolver();
            this.address = address;
            this.body = body;
        }
        else {
            throw new IllegalArgumentException(
                "Context must implement OnSmsSentListener interface");
        }
    }

    public void start() {
        if (resolver != null) {
            resolver.registerContentObserver(uri, true, this);
        }
        else {
            throw new IllegalStateException(
                "Current SmsObserver instance is invalid");
        }
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        Cursor cursor = null;

        try {
            cursor = resolver.query(uri, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                final int type = cursor.getInt(
                    cursor.getColumnIndex(Telephony.Sms.TYPE));

                if(type == Telephony.Sms.Sent.MESSAGE_TYPE_SENT) {
                    final String address = cursor.getString(
                        cursor.getColumnIndex(Telephony.Sms.ADDRESS));
                    final String body = cursor.getString(
                        cursor.getColumnIndex(Telephony.Sms.BODY));
                    final int threadId = cursor.getInt(
                        cursor.getColumnIndex(Telephony.Sms.THREAD_ID));

                    if (PhoneNumberUtils.compare(address, this.address) &&
                        body.equals(this.body)) {

                        ((OnSmsSentListener) context).onSmsSent(threadId);
                        resolver.unregisterContentObserver(this);
                    }
                }
            }
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}