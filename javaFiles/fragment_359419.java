public class NewMainActivity extends HomeScreenActivityFromLibrary {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View viewFromLibrary = getLayoutInflater().inflate(
                                      library.package.name.R.layout.home_screen, null);

        // Make changes; add Buttons to `viewFromLibrary`
        // Add functionality to Buttons; setOnClickListeners

        setContentView(viewFromLibrary);
    }
}