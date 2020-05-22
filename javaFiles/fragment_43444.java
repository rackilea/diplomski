private void readFromIntent(Intent intent) {
    String action = intent.getAction();
    if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
            || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
            || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
        Parcelable[] rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        NdefMessage[] messages = null;
        if (rawMessages != null) {
            messages = new NdefMessage[rawMessages.length];
            for (int i = 0; i < rawMessages.length; i++) {
                messages[i] = (NdefMessage) rawMessages[i];
                NdefRecord [] records = messages[i].getRecords();
 //if you are sure you have text then you don't need to test TNF
                for(NdefRecord record: records){
                    processRecord(record);
                }
            }
        }
    }
}
public void processRecord(NdefRecord record) {

    short tnf = record.getTnf();
    switch (tnf) {

        case NdefRecord.TNF_WELL_KNOWN: {
            if (Arrays.equals(record.getType(), NdefRecord.RTD_TEXT)) {
                String yourtext = processRtdTextRecord(record.getPayload());
            } else if (Arrays.equals(record.getType(), NdefRecord.RTD_URI)) {
                String yourtext = record.toUri().toString();
            } else if (Arrays.equals(record.getType(), NdefRecord.RTD_SMART_POSTER)) {
                processSmartPosterRecord(record);
            } else {
                //Record is not Text or URI or Poster
            }
        }
        case NdefRecord.TNF_MIME_MEDIA: {
            if (record.toMimeType().equals("MIME/Type")) {
               // handle this as you want
            } else {
                //Record is not our MIME
            }
        }
  // you can write more cases
        default: {
            //unsupported NDEF Record
        }
    }
}

private String processRtdTextRecord(byte[] payload) {
    String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
    int languageCodeLength = payload[0] & 0063;

    String text = "";
    try {
        text = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        Log.e("UnsupportedEncoding", e.toString());
    }
    return text;
}