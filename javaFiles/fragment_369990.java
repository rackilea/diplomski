protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

     NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
     if (nfcAdapter == null){ 
        Toast.makeText(this, "NFC not available", Toast.LENGTH_SHORT).show();
        return;  
     }else{
          Toast.makeText(this, "NFC is avalable", Toast.LENGTH_SHORT).show();
     }
     ....
     ....
 }