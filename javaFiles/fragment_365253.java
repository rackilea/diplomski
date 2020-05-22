@Override
public void onNewIntent(final Intent intent) {
  setIntent(intent);
  if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
    processIntent(intent);
  }
}