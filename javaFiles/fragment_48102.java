public class MainActivity extends Activity {

    EditText edit;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit  = (EditText) findViewById(R.id.box);
        button  = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String string = edit.getText().toString();
                switch (string){
                    case "c":
                        MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.sample1);
                        mp1.start();
                        break;
           }
       }
    }
}