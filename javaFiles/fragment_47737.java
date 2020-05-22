public class SendSmsActivity extends Activity {
Button buttonSend,get;
private static final int CONTACT_PICKER_RESULT = 1001;
EditText phoneNo;
EditText textSMS;
int columnIndex_number;
static String stringNumber;
String sms;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.send);
    phoneNo = (EditText)findViewById(R.id.editText1);
    textSMS = (EditText) findViewById(R.id.editText2);
    get = (Button) findViewById(R.id.button1);
    get.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
             Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                    Contacts.CONTENT_URI);
            startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);


        }
        });
    buttonSend = (Button) findViewById(R.id.button2);    
    buttonSend.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v){
          try {

              String sms =  textSMS.getText().toString().trim();
                Toast.makeText(getApplicationContext(), phoneNo.getText().toString()+sms,
                        Toast.LENGTH_LONG).show();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo.getText().toString(), null, sms, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!",
                        Toast.LENGTH_LONG).show();

          } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                "SMS faild, please try again later!",
                Toast.LENGTH_LONG).show();
            e.printStackTrace();
          }


        }
    });
}

 @Override  
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
 if (resultCode == RESULT_OK) {  
    switch (requestCode) {  
    case CONTACT_PICKER_RESULT:

        Cursor cursor = null;  
        String phoneNumber = "";
        List<String> allNumbers = new ArrayList<String>();
        int phoneIdx = 0;
        try {  
            Uri result = data.getData();  
            String id = result.getLastPathSegment();  
            cursor = getContentResolver().query(Phone.CONTENT_URI, null, Phone.CONTACT_ID + "=?", new String[] { id }, null);  
            phoneIdx = cursor.getColumnIndex(Phone.DATA);
            if (cursor.moveToFirst()) {
                while (cursor.isAfterLast() == false) {
                    phoneNumber = cursor.getString(phoneIdx);
                    allNumbers.add(phoneNumber);
                    phoneNo.setText(cursor.getString(phoneIdx));

                    cursor.moveToNext();
                }
            } else {
                //no results actions
            }  
        } catch (Exception e) {  
           //error actions
        } finally {  
            if (cursor != null) {  
                cursor.close();
            } 
        }  
        break;  
    }  
} else {
   //activity result error actions
}  
}
}