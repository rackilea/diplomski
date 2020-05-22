public class SendMessage extends Activity {

EditText ed1,ed2;
static int ResultCode= 12;
ArrayList<String> sendlist = new ArrayList<String>();
Button b1,b2;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sendmessage);
    b2 = (Button) findViewById(R.id.button2);
    ed1= (EditText)findViewById(R.id.editText1);
    ed2= (EditText)findViewById(R.id.editText2);
    b1 = (Button) findViewById(R.id.button1);
    b2.setOnClickListener(new OnClickListener()
     {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent i = new Intent(SendMessage.this, MainActivity.class);
        startActivityForResult(i, ResultCode);
    }

 });

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


protected void onActivityResult(int requestCode, int resultCode, Intent data) {

      if (requestCode == ResultCode) {

         if(resultCode == RESULT_OK){      
             sendlist  =data.getStringArrayListExtra("name");
             if(sendlist!=null)
                {
                for(int i=0;i<sendlist.size();i++)
                {
                    ed1.append(sendlist.get(i).toString());
                    ed1.append(";");
                }

         }
         if (resultCode == RESULT_CANCELED) {    

         }
      }
    }
}
}

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent" >

<EditText
    android:id="@+id/editText1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_alignParentLeft="true"
    android:layout_alignParentRight="true"
    android:layout_alignParentTop="true"
    android:layout_marginTop="18dp"
    android:ems="10" >

    <requestFocus />
</EditText>

<EditText
    android:id="@+id/editText2"
    android:layout_width="wrap_content"
    android:layout_height="200dp"
    android:layout_alignParentLeft="true"
    android:layout_alignParentRight="true"
    android:layout_below="@+id/editText1"
    android:layout_marginTop="62dp"
    android:ems="10" />

<TextView
    android:id="@+id/textView1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_alignTop="@+id/editText1"
    android:layout_centerHorizontal="true"
    android:text="Phone Numbers" />

<TextView
    android:id="@+id/textView2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_below="@+id/editText1"
    android:layout_centerHorizontal="true"
    android:layout_marginTop="37dp"
    android:text="Message" />

<Button
    android:id="@+id/button1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_alignLeft="@+id/textView2"
    android:layout_alignParentBottom="true"
    android:text="Send" />

<Button
    android:id="@+id/button2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_alignBaseline="@+id/textView2"
    android:layout_alignBottom="@+id/textView2"
    android:layout_alignParentRight="true"
    android:text="Get" />

 </RelativeLayout>