private void removeMessage(Context context, String fromAddress) {

        Uri uriSMS = Uri.parse("content://sms/inbox");
        Cursor cursor = context.getContentResolver()
                                       .query(uriSMS, null, null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            int ThreadId = cursor.getInt(1);
            Log.d("Thread Id", ThreadId+" id - "+cursor.getInt(0));
            Log.d("contact number", cursor.getString(2));
            Log.d("column name", cursor.getColumnName(2));

            context.getContentResolver().delete(Uri.
                   parse("content://sms/conversations/"+ThreadId), "address=?", 
                                                     new String[]{fromAddress});
            Log.d("Message Thread Deleted", fromAddress);
        }
        cursor.close();
    }