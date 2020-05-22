netReceiver = new ConnectStatusReceiver();
IntentFilter netFilter = new IntentFilter();
netFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
Intent intent = registerReceiver(netReceiver, netFilter);
if (intent != null) {
    // broadcast is sticky
}