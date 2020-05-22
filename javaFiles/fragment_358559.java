/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {

    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String CITY = "CITY";

    TextView cityName;
    TextView text;

    public DescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        text = view.findViewById(R.id.city_description);
        cityName = view.findViewById(R.id.city_name);

        if (savedInstanceState != null) {
            String description = savedInstanceState.getString(DESCRIPTION);
            String city = savedInstanceState.getString(CITY);
            change(description, city);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the fragments Instance
        outState.putString(DESCRIPTION, text.getText().toString());
        outState.putString(CITY, cityName.getText().toString());
    }

    public void change(String description, String city) {
        text.setText(description);
        cityName.setText(city);
    }
}