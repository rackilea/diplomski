Cursor mCursor = db.query(true, "Users_Details",
            str,
            "KEY_EMAIL" + "='" + email + "'", null, null, null, null,
            null);
    if (mCursor != null) {
        mCursor.moveToFirst();
    }