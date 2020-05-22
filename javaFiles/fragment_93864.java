public class MainActivity extends Activity {
    private ActivityMainBinding binding;
    public final ObservableBoolean partyIsCreated = new ObservableBoolean(false);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);
    }

    public void partyClicked() {
        partyIsCreated.set(!partyIsCreated.get());
    }
}