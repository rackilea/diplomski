@Override 
protected void onPause() {
    super.onPause();
    mAdapter.disableForegroundDispatch(this);
}

@Override 
protected void onResume(){
  super.onResume();
  PendingIntent pendingIntent=PendingIntent.getActivity(this,0,new Intent(this,getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),0);
  IntentFilter ndef=new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
  try {
    ndef.addDataType("*/*");
  }
 catch (  MalformedMimeTypeException e) {
    Log.e(TAG,"Bad MIME type declared",e);
    return;
  }
  IntentFilter[] filters=new IntentFilter[]{ndef};
  String[][] techLists=new String[][]{new String[]{Ndef.class.getName()},new String[]{NdefFormatable.class.getName()}};
  mNfcAdapter.enableForegroundDispatch(this,pendingIntent,filters,techLists);
}

@Override 
protected void onNewIntent(Intent intent) {
    Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
    String[] techList = tag.getTechList();
    for (String tech : techList) {
          if (tech.equals(Ndef.class.getName())) {
              //write NDEF msg
          } else if (tech.equals(NdefFormatable.class.getName())) {
              //format and write NDEF msg
          }
    }
}