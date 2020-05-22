private Bundle timer2extras;
private String timer2string;
private long starttime;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timer_2);

    // Find views 

    timer2extras = getIntent().getExtras();
    timer2string = timer2extras.getString("timer2string");
    starttime = Integer.parseInt(timer2string);

    // ...
}