@Override
public IBinder onBind(Intent intent) {
    return mBinder;
}

@Override
public boolean onUnbind(Intent intent) {

    return super.onUnbind(intent);
}

private final IBinder mBinder = new PlayMusicServiceBinder();