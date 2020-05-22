public class SendMessage extends Activity {

EditText ed1,ed2;
ArrayList<String> sendlist = new ArrayList<String>();
Button b1;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sendmessage);
    ed1= (EditText)findViewById(R.id.editText1);
    ed2= (EditText)findViewById(R.id.editText2);
    Bundle extras = getIntent().getExtras();
    if(extras!=null)
    {
        sendlist = extras.getStringArrayList("name");
        if(sendlist!=null)
        {
        for(int i=0;i<sendlist.size();i++)
        {
            ed1.append(sendlist.get(i).toString());
            ed1.append(";");
        }
    }
    }
    else
    {
        Toast.makeText(getApplicationContext(), "null",
                Toast.LENGTH_LONG).show();
    }
    b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new OnClickListener()
    {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            for(int i=0;i<sendlist.size();i++)
            {

                if(ed2.getText().length()>0)
                {
                  try {
                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(sendlist.get(i).toString(), null, ed2.getText().toString(), null, null);

                        Toast.makeText(getApplicationContext(), "SMS Sent!",
                                    Toast.LENGTH_LONG).show();
                      } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                      }
                }
            }

        }

    });
}   
}