if (cursor != null) {
    cursor.moveToFirst();
   String title = cursor.getString(cursor.getColumnIndexOrThrow(NotesDbAdapter.KEY_TITLE));
   String body = cursor.getString(cursor.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY));
   String date = cursor.getString(cursor.getColumnIndexOrThrow(NotesDbAdapter.KEY_DATE));
   mTitleText.setText(title);
   mBodyText.setText(body);
   mDateText.setText(date);
}