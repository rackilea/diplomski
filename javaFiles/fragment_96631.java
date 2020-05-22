public class MainActivity extends AppCompatActivity implements  ObservableScrollViewCallbacks {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_layout);
         ObservableScrollView observableScrollView = (ObservableScrollView) findViewById(R.id.observable_scrollview);
         observableScrollView.setScrollViewCallbacks(this);
         imageView = (ImageView) findViewById(R.id.image_view);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
         imageView.setTranslationY(scrollY / 2);
    } 
}