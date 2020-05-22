public class Main extends Activity implements MyCountDownTimer.MyCallback 
{
    private MyCountDownTimer myCountDownTimer;

    @Override
    public void callback(){
        Log.e("Testing", "OK na");
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        myCountDownTimer = new MyCountDownTimer(5000, 1000);
        myCountDownTimer.setMyCallback(this); //will use the callback method in this class which can be different for each activity
        myCountDownTimer.start();
    }
}