public class SecondActivity extends PhoneStateListener {
    Context mcontext;
    double value1=0,value2=0;
    String error,ss;
    private MainActivity first_activity_instance;
    public SecondActivity(Context context){
        mcontext=context;
        first_activity_instance =(MainActivity)mcontext;
    }
    public void onSignalStrengthsChanged(SignalStrength signalStrength){
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength.isGsm()) {
            value1=signalStrength.getGsmBitErrorRate();
            error="\nGsmBitErrorRate:"+value1;
            value2=signalStrength.getGsmSignalStrength();
            ss="\nGsmSignalStrength:"+value2;
            //now pass them to your to your activity instance
            first_activity_instance.do_what_you_wanna_do_with_these_two_values(value1,value2);
        }
    }
}