private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(NfcAdapter.ACTION_ADAPTER_STATE_CHANGED)) {
            final int state = intent.getIntExtra(NfcAdapter.EXTRA_ADAPTER_STATE,
                                                 NfcAdapter.STATE_OFF);
            switch (state) {
            case NfcAdapter.STATE_OFF:
                break;
            case NfcAdapter.STATE_TURNING_OFF:
                break;
            case NfcAdapter.STATE_ON:
                break;
            case NfcAdapter.STATE_TURNING_ON:
                break;
            }
        }
    }
};

@Override
public void onDestroy() {
    super.onDestroy();

    // Remove the broadcast listener
    this.unregisterReceiver(mReceiver);
}

  // The following check needs to also be added to the onResume
@Override
protected void onResume() 
    super.onResume();
  // Check for available NFC Adapter
    PackageManager pm = getPackageManager();
    NfcManager manager = (NfcManager) getSystemService(Context.NFC_SERVICE);
    NfcAdapter adapter = manager.getDefaultAdapter();

    if(adapter != null && adapter.isEnabled()) {
        createNfcDetector();
        onNfcFeatureFound();
    }
    else {
        onNfcFeatureNotFound();
    }
}