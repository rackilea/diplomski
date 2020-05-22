public class SandBoxActivity extends Activity {

    private Button testButton;

    private CharSequence[] _options = {"Aveiro", "Coimbra", "Porto", "Minho"};

    private boolean[] _selections = {true, true, true, false};

    private AlertDialog test;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        test = new AlertDialog.Builder(this)
        .setTitle("Cities")
        .setMultiChoiceItems(_options, _selections, new DialogInterface.OnMultiChoiceClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int clicked, boolean selected) {
                        Log.i("Database", _options[clicked] + " selected: " + selected);
                }

        })
        .setPositiveButton("OK", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int clicked) {
                    switch(clicked) {
                        case DialogInterface.BUTTON_POSITIVE:
                            for( int i = 0; i < _options.length; i++ ){
                                Log.i("Database", "id: " + " " + _options[i] + " selected: " + _selections[i]);
                            }
                            break;
                    }
                }
        })
        .create();

        this.testButton = (Button) findViewById(R.id.color_button);
        this.testButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                test.show();
            }
        });
    }
}