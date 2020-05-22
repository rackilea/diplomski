@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // ..
    // only try to set up NFC on API10+
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
        // Check for available NFC Adapter
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter != null) {
            nfcAdapter.setNdefPushMessage(
                    new NdefMessage(NdefRecord.createUri(Uri.encode("http://www.google.com/"))),
                    this);
        }
    }
}