public class MainActivity extends Activity {

    ImageView imageToBeDragged;
    ImageView targetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageToBeDragged = (ImageView)findViewById(R.id.imagetodrag);
        targetImage = (ImageView)findViewById(R.id.target);
        imageToBeDragged.setOnTouchListener(new ChoiceTouchListener());
        targetImage.setOnDragListener(new ChoiceDragListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}