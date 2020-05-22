public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMyLocation();

    }

    //Removed the view object paramter as its not required
    public void showMyLocation() {
        startActivity(new Intent(getApplicationContext(),MapsActivity.class));
    }
}