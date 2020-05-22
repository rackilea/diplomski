private static final int steps[] =
        {R.raw.step_1, R.raw.step_2, R.raw.step_3, R.raw.step_4, R.raw.step_5, R.raw.step_6, R.raw.step_7, R.raw.step_8, R.raw.step_9, R.raw.step_10
        };
private int i = 0;
private ArrayList<MediaPlayer> voices = new ArrayList<>(10);
private Button btnPlay;
private Button btnStop;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btnPlay = (Button) findViewById(R.id.btnPlay);
    btnPlay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(i==10)i=0;
            final MediaPlayer voice = MediaPlayer.create(MainActivity.this, steps[i++]);
            voice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (voice != null) {
                        voices.remove(voice);
                        voice.release();
                    }
                }
            });
            voice.start();
            voices.add(voice);
        }
    });
    btnStop = (Button) findViewById(R.id.btnStop);

    btnStop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int j = voices.size() - 1; j >= 0; j--) {
                if (voices.get(j) != null) {
                    if (voices.get(j).isPlaying())
                        voices.get(j).stop();
                    voices.get(j).release();
                    voices.remove(j);
                }
            }
        }
    });

}