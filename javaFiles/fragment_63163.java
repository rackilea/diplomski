MediaPlayer mp = null;  //Declaring globally so can access anywhere in activity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_manual);
        Button one = (Button) this.findViewById(R.id.instructionsManual_but);
        mp = MediaPlayer.create(this, R.raw.instructions_manual);
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
            }
        });
    }