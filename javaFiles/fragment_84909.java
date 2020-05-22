@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            button = (Button)findViewById(R.id.button6);

            textview = (TextView)findViewById(R.id.textView2);

            context = getApplicationContext();

            audiomanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    audiomanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

                    textview.setText("Silent Mode Enable");

                }
            });
        }