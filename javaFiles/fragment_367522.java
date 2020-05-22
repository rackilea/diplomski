public class MainActivity extends ActionBarActivity {

    private MediaPlayer musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mpBtnsom = MediaPlayer.create(this, R.raw.somvoa);
        ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);

        musica = MediaPlayer.create(this, R.raw.sommusica);
        musica.start();
        musica.setLooping(true);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mpBtnsom.start();
            }
        });
    }

    public void toast2(View view){
        Toast toast = Toast.makeText(MainActivity.this, "Botão ToastMessage", Toast.LENGTH_LONG);
        toast.show();
    }

    public void toast(View view){
        Toast toast = Toast.makeText(MainActivity.this, "Botão Felpudo", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onPause(){
        super.onPause();

        musica.stop();
        finish();
    }
}