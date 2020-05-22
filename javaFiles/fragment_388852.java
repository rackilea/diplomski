Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
            NfcAdapter.EXTRA_NDEF_MESSAGES);
// only one message sent during the beam
NdefMessage[] msg = = new NdefMessage[rawMsgs.length];
for (int i = 0; i < msg.length; i++) {
    msg[i] = (NdefMessage) rawMsgs[i];
    // record 0 contains the MIME type, record 1 is the AAR, if present
    beamMsg[i].setText(new String(msg[i].getRecords()[0].getPayload());
    beamMsg2[i].setText(new String(msg[i].getRecords()[1].getPayload()));
}