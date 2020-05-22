public class MainActivity extends ActionBarActivity {
private BubblesManager bubblesManager;
private boolean isCheckedValue;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeBubblesManager();


    final Button add = (Button) findViewById(R.id.add);
    add.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            addNewBubble();
            add.setEnabled(false);
        }
    });

    CheckBox checkBox = (CheckBox)findViewById(R.id.add_fb);
    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            isCheckedValue = isChecked;
// un-comment this code if you want to go to second activity when check change 
//
//                Intent intent = new Intent(MainActivity.this, PopUpWindow.class);
//                intent.putExtra("yourBoolName", isCheckedValue );
//  startActivity(intent);
        }
    });

}
 private void addNewBubble() {
        BubbleLayout bubbleView = (BubbleLayout)LayoutInflater.from(MainActivity.this).inflate(R.layout.bubble_layout, null);
        bubbleView.setOnBubbleRemoveListener(new BubbleLayout.OnBubbleRemoveListener() {
            @Override
            public void onBubbleRemoved(BubbleLayout bubble) {
                finish();
                System.exit(0);
            }
        });
        bubbleView.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {

            @Override
            public void onBubbleClick(BubbleLayout bubble) {
                Intent in = new Intent(MainActivity.this, PopUpWindow.class);
            in.putExtra("yourBoolName", isCheckedValue );
                startActivity(in);
            }
        });
        bubbleView.setShouldStickToWall(true);
        bubblesManager.addBubble(bubbleView, 60, 20);
    }
}


   public class PopUpWindow extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

setContentView(R.layout.activity_pop_up_window);


DisplayMetrics dm = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(dm);

int width = dm.widthPixels;
int height = dm.heightPixels;

getWindow().setLayout((int)(width*.8),(int)(height*.6));

Boolean yourBool = getIntent().getBooleanExtra("yourBoolName",false);
Button fbbutton1 = (Button)findViewById(R.id.fbbutton1);
if(yourBool){
        //For Displaying Button
    fbbutton1.setVisibility(View.VISIBLE);
    }


}
}