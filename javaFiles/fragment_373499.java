public class MainActivity extends AppCompatActivity implements LoadingButton.OnLoadingButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // My new component (it's id in activity_main.xml is 'lb') 
        LoadingButton lb = (LoadingButton) findViewById(R.id.lb);
        lb.setOnLoadingClickListener(this);

    }

    @Override
    public void onLoadingButtonClickListener() {
        //do your stuff on ok button click
    }
}