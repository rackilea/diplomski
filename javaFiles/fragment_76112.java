public class DemoActivity extends Activity{

    Button buildings;   
    Button foodcourt;    

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buildings = (Button) findViewById(R.id.button1);
        foodcourt = (Button) findViewById(R.id.button2); 

        registerForContextMenu(Buildings); 
        registerForContextMenu(foodcourt);   
}
//rest of your code...