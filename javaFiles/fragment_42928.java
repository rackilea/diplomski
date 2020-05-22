Uri[] alarms = new Uri[alCursor.getCount()];
while(alCursor.moveToNext()) {
    int pos = alCursor.getPosition();
    alarms[pos] = ringtoneMgr.getRingtoneUri(pos);
}
alCursor.close();