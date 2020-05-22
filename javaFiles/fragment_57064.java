private final int delayTime = 3000;
private Handler myHandler = new Handler();

@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.playcontrols);

    View exitButton = findViewById(R.id.controls_exit_pane);
    exitButton.setOnClickListener(this);
    View volUpButton = findViewById(R.id.controls_vol_up);
    volUpButton.setOnClickListener(this);
    View playButton = findViewById(R.id.controls_play);
    playButton.setOnClickListener(this);
    View volDownButton = findViewById(R.id.controls_vol_down);
    volDownButton.setOnClickListener(this);

    musicPlayback();

    myHandler.postDelayed(closeControls, delayTime);

}