String[] projection_columns = new String[]{
    AlarmReminderContract.AlarmReminderEntry._ID,
    AlarmReminderContract.AlarmReminderEntry.KEY_TITLE,
    AlarmReminderContract.AlarmReminderEntry.KEY_DATE,
    AlarmReminderContract.AlarmReminderEntry.KEY_TIME,
    AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT,
    AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_NO,
    AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_TYPE,
    AlarmReminderContract.AlarmReminderEntry.KEY_LOCATION,
    AlarmReminderContract.AlarmReminderEntry.KEY_ACTIVE,
    AlarmReminderContract.AlarmReminderEntry.latitude,
    AlarmReminderContract.AlarmReminderEntry.longitude
}

your_provider.query(your_uri, project_columns,your_selection, your_selectionargs, you_sortorder);