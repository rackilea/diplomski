List<Uri> listRingtones = new ArrayList<Uri>();
int ringTypes[] = {RingtoneManager.TYPE_ALARM,
                   RingtoneManager.TYPE_RINGTONE,
                   RingtoneManager.TYPE_NOTIFICATION};

for (int ringType : ringTypes) {

    RingtoneManager ringtoneMgr = new RingtoneManager(this);
    ringtoneMgr.setType(ringType);
    Cursor alarmsCursor = ringtoneMgr.getCursor();
    if (alarmsCursor.getCount() == 0 && !alarmsCursor.moveToFirst()) {
        return null;
    }

    while (!alarmsCursor.isAfterLast() && alarmsCursor.moveToNext()) {
        listRingtones.add(
                   ringtoneMgr.getRingtoneUri(alarmsCursor.getPosition()));
    }

    alarmsCursor.close();
}