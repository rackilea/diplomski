try this:
  int type = mCursor.getInt(mCursor.getColumnIndex(Phone.TYPE));
       the "type" value will be 1,2,3 or 4 where
        TYPE_HOME = 1;
        TYPE_MOBILE = 2;
        TYPE_WORK = 3;
        TYPE_OTHER = 7;