public class EnterDetails extends AppCompatActivity {

    private boolean isDetailsEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_details);
        isDetailsEmpty = getIntent().getBooleanExtra("test1", false)
    }

    public void onClickSave(View v){
        if(isDetailsEmpty) {
        ...
    }
}