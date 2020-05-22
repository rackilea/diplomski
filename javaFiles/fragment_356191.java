Cursor cursor = this.getReadableDatabase().query(
        REMINDER_NOTE_TABLE,
        new String[]{KEY_ID, KEY_NOTE, KEY_AUTHOR},
        Strings.isEmpty(author) ? null : KEY_AUTHOR + " LIKE ?",
        Strings.isEmpty(author) ? null : new String[]{"%" + author + "%"},
        null, null, null);