Parcelable[] messages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
if (messages != null) {
    NdefMessage[] ndefMessages = new NdefMessage[messages.length];
    for (int i = 0; i < messages.length; i++) {
        ndefMessages[i] = (NdefMessage) messages[i];
    }
    // process messages, usually only a single is present
}