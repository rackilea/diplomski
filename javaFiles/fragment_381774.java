public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] btnIds = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4};
    private List<Button> buttonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_group);

        for(int i = 0; i < btn.length; i++){
            buttonList.add(findViewById(btnIds[i])); 
            buttonList.get(i).setOnClickListener(this);
        }
        ...
    }
    ...
    @Override
    public void onClick(View v) {
        //Either check for button ids or simply:
        for (Button button : buttonList) {
            button.setVisibility(View.INVISIBLE);//or View.GONE
        }
    }
}