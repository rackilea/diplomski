public class MainActivity extends AppCompatActivity {
private PendingIntent pendingIntent;
private IntentFilter[] writeTagFilters;
private NfcAdapter nfcAdapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTheme(R.style.AppTheme);
    setContentView(R.layout.activity_main);
    nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    if (nfcAdapter == null) {
        Toast.makeText(this, "No NFC", Toast.LENGTH_SHORT).show();
        finish();
        return;
    }
    setForeground();

}
 private void setForeground() {
    pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
    tagDetected.addCategory(Intent.CATEGORY_DEFAULT);
    writeTagFilters = new IntentFilter[]{tagDetected};
}
@Override
protected void onResume() {

    super.onResume();
    if (nfcAdapter != null) {
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
    }
    processNfcTag(getIntent());
}
@Override
protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
}

@Override
protected void onPause() {

    super.onPause();
    if (nfcAdapter != null) {
        nfcAdapter.disableForegroundDispatch(this);
    }

}

private void processNfcTag(Intent intent) {
//TODO: here you should to check if this intent is an NFC Intent, in case it is an nfc intent you could read it according of tag tech you have 
// for example MifareUltralight.
MifareUltralight mfu = MifareUltralight.get(intent.getParcelableExtra(NfcAdapter.EXTRA_TAG));
try {
        mfu.connect();
        byte [] bytes = mfu.readPages(pageNumber);
        mfu.close();
    } catch (IOException e) {
        e.printStackTrace();

    }
// then you could get this bytes and send it to the other activity 
}