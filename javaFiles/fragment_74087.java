public class TimerActivity extends Activity
{
    CountDownTimer cntTimer = null;
    ImageButton startTimerButton;
    EditText timerText;
    TextView timerTextValue;
    boolean checkstate =false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timers);

        startTimerButton = (ImageButton)findViewById(R.id.timer1ImageButton);

        timerText = (EditText) findViewById(R.id.timerEditText1);

        timerTextValue = (TextView) findViewById(R.id.timerTextView);

        timerCountDown();
    }

    public void timerCountDown()
    {
        Integer input = 0;
        if(timerText.getText().toString()!="")
            {
                 input = Integer.parseInt(timerText.getText().toString())*1000 ;
            }

        CountDownTimer timer = new CountDownTimer(input, 1000)
        {
             public void onTick(long millisUntilFinished) 
             {
                 timerTextValue.setText("seconds remaining: " + millisUntilFinished / 1000);
             }

             public void onFinish() 
             {
                 timerTextValue.setText("done!");

             }
        };

        timerStatus(timer);
    }

    public void timerStatus(final CountDownTimer downTimer) 
    {
        startTimerButton.setOnClickListener(new View.OnClickListener() 
        {
              public void onClick(View v) 
              {
                    if(checkstate==false)
                {
                    startTimerButton.setImageResource(android.R.drawable.ic_secure);
                    //Error
                    checkstate = true;
                    downTimer.start();
                }
                else
                {
                    startTimerButton.setImageResource(android.R.drawable.ic_delete);
                    //Error
                    checkstate = false;
                    downTimer.cancel();
                }
             }
            });
    }

}