protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

    home = (Button) findViewById(R.id.home);
    pocket = (Button) findViewById(R.id.pocket);
    silent = (Button) findViewById(R.id.silent);
    mode = (Button) findViewById(R.id.mode);
    tv = (TextView) findViewById(R.id.tv);

    myAudManHolder = new Listeners(am);

    pocket.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick(View v) {
            myAudManHolder.vibrate();
        }
    });
}