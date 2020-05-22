/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    // attach the OnTouchListener to your TargetTrainer view:
    (TargetTrainer)findViewById(R.id.myTargetTrainer).setOnTouchListener(this);
}