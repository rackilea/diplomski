@Override
public void set(int type, long triggerAtTime, long windowLength, long interval, int flags,
        PendingIntent operation, WorkSource workSource,
        AlarmManager.AlarmClockInfo alarmClock) {
    final int callingUid = Binder.getCallingUid();
    if (workSource != null) {
        getContext().enforcePermission(
                android.Manifest.permission.UPDATE_DEVICE_STATS,
                Binder.getCallingPid(), callingUid, "AlarmManager.set");
    }

    // No incoming callers can request either WAKE_FROM_IDLE or
    // ALLOW_WHILE_IDLE_UNRESTRICTED -- we will apply those later as appropriate.
    flags &= ~(AlarmManager.FLAG_WAKE_FROM_IDLE
            | AlarmManager.FLAG_ALLOW_WHILE_IDLE_UNRESTRICTED);

    // Only the system can use FLAG_IDLE_UNTIL -- this is used to tell the alarm
    // manager when to come out of idle mode, which is only for DeviceIdleController.
    if (callingUid != Process.SYSTEM_UID) {
        flags &= ~AlarmManager.FLAG_IDLE_UNTIL;
    }

    // If the caller is a core system component, and not calling to do work on behalf
    // of someone else, then always set ALLOW_WHILE_IDLE_UNRESTRICTED.  This means we
    // will allow these alarms to go off as normal even while idle, with no timing
    // restrictions.
    if (callingUid < Process.FIRST_APPLICATION_UID && workSource == null) {
        flags |= AlarmManager.FLAG_ALLOW_WHILE_IDLE_UNRESTRICTED;
    }

    // If this is an exact time alarm, then it can't be batched with other alarms.
    if (windowLength == AlarmManager.WINDOW_EXACT) {
        flags |= AlarmManager.FLAG_STANDALONE;
    }

    // If this alarm is for an alarm clock, then it must be standalone and we will
    // use it to wake early from idle if needed.
    if (alarmClock != null) {
        flags |= AlarmManager.FLAG_WAKE_FROM_IDLE | AlarmManager.FLAG_STANDALONE;
    }

    setImpl(type, triggerAtTime, windowLength, interval, operation,
            flags, workSource, alarmClock, callingUid);
}