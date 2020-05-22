CountDownTimer timer;

public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.jeu);

    int timeinminutes=1;

    timer = new CountDownTimer(timeinminutes*21000, 1000) 
    {

        TextView jeutimer = (TextView) findViewById(R.id.jeu_timer);

         public void onTick(long millisUntilFinished) 
         {
             long scnds=0;
             scnds=(millisUntilFinished/1000);
             jeutimer.setText( "" + scnds);
         }


         public void onFinish() 
         {

         }
  }.start();