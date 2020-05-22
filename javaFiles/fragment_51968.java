if (mNfcAdapter == null) {
    myText.setText("NFC is not available on this device.");
    myText.setEnabled(false);
} else {
    mNfcAdapter.setNdefPushMessageCallback(this, this, new Activity[0]);
    mNfcAdapter.setOnNdefPushCompleteCallback(this, this, new Activity[0]);
}