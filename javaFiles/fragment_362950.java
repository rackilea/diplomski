public class MainActivity extends AppCompatActivity {
        private int currentnumber,mod,delay,Curclicks;
    private TextView display;
    private Handler handler;
    private Button next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //Binding
        display = findViewById(R.id.tx);
        next_button = findViewById(R.id.next_button);
        //getResources
        Resources res = getResources();

        //getting the data ready
        String[] list = {"1","2","3","4","5","6","7"};
        //assign vars
        handler = new Handler();
        currentnumber = 0;
        Curclicks=0;
        mod = 5;
        delay = 5000;
        //initial view
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(currentnumber == list.length){
                currentnumber = 0;
            }
            if (Curclicks == mod-1) {
                next_button.setEnabled(false);
                display.setText(list[currentnumber]);
                currentnumber++;


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //the button will unlock after the delay specified
                        next_button.setEnabled(true);
                        Curclicks = 0;
                    }
                }, delay);
            }
            else {
                display.setText(list[currentnumber]);
                currentnumber++;

            }
            Curclicks++;

        }

    });
}
    }