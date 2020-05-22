public class ChooseLevel extends AppCompatActivity {
Button firstlevel;
TextView tv;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose_level);

    firstlevel = (Button)findViewById(R.id.firstlevelBtn);
    //tv  = (TextView)findViewById(R.id.titleTextTraining); //this is the textview of the second activity

   firstlevel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //start the second activity   
            Intent showTrainings = new Intent(ChooseLevel.this, ShowTrainings.class);
            showTrainings.putExtra("TEXTID", "THE TEXT YOU WANT TO PASS");
            startActivity(showTrainings);


        }
    });
}