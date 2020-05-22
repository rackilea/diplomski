public class MyActivity extends AppCompatActivity implements MyFragment.Test {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public void imLeavingYou() {
        // Okay thanks for informing
    }
}