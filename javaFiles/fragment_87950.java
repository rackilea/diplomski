public class MainActivity extends Activity {
private CanvasView canvasView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.activity_main);

    canvasView = findViewById(R.id.custom_view)
}

...

@Override
public boolean onOptionsItemSelected(MenuItem item) {

    ...
    canvasView.invalidate();
    ...
}