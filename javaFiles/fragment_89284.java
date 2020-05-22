@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        setUpUI();
}
public void setUpUI()
{
    TrackingJob.schedulePeriodic();
}