public class AddJourneyActivity extends AppCompatActivity {

    private static final String TAG = AddJourneyActivity.class.getSimpleName();

    private AddJourneyViewModel addJourneyViewModel;
    private EditText departureTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journey);

        JourneyStoreApplication app = (JourneyStoreApplication) getApplication();
        addJourneyViewModel = ViewModelProviders
                // Gets the ViewModelFactory instance and creates the ViewModel.
                .of(this, app.getViewModelFactory())
                .get(AddJourneyViewModel.class);

        departureTextField = findViewById(R.id.addjourney_departure_addr_txt);
    }

    //...
}