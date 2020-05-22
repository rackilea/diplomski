@Override
public void onResume() {
    final IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
    getContext().registerReceiver(receiver, filter);
}

@Override
public void onPause() {
    getContext().unregisterReceiver(receiver);
}