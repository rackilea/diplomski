public class MainActivity extends AppCompatActivity {
TextView tv;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv=(TextView)findViewById(R.id.info);
}
public void onSubmit(View v) {
    TelephonyManager tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    tm.listen(new SecondActivity(this),PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    String opname="\nOperator ID:"+" "+tm.getNetworkOperator();
    opname=opname+"\nOperator Name:"+" "+tm.getNetworkOperatorName();

    int phoneType=tm.getPhoneType();
    String ptype="";
    switch(phoneType)
    {
        case TelephonyManager.PHONE_TYPE_CDMA:
            ptype="\nPhone Type: CDMA\n";
            break;
        case TelephonyManager.PHONE_TYPE_GSM:
            ptype="\nPhone Type: GSM\n";
            break;
        case TelephonyManager.PHONE_TYPE_SIP:
            ptype="\nPhone Type: SIP\n";
            break;
        case TelephonyManager.PHONE_TYPE_NONE:
            ptype="\nPhone Type: NONE\n";
            break;
    }
    tv.setText(opname+ptype);
}

//declare a public method which is accessable in onSignalStrengthsChanged callback in the second class.
        public void do_what_you_wanna_do_with_these_two_values(double value1,double value2){
            tv.setText("here are my values: "+String.valueOf(value1)+" , "+String.valueOf(value1));
        }
}