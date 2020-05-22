final Button phonenumberhotel;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hotel);
    addButtonListener();
    addListenerOnButton();

}


public void addListenerOnButton() {

    phonenumberhotel = (Button) findViewById(R.id.phonenumberhotel);

    phonenumberhotel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
             String number = phonenumberhotel.getText().toString()
             ClipData clip = ClipData.newPlainText("Phone number",number);   
             clipboard.setPrimaryClip(clip);
             Toast.makeText(getBaseContext(), "Phone number has been copied", Toast.LENGTH_LONG).show();
        }
    });


}