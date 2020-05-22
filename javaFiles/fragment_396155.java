public class MyFragment extends Fragment{

private String[] choices = new String[]{"one", "two", "three"};

// Initial position
private int spinnerPosition = 0;

private static final String SPINNER_ITEM_POSITION = "whatever_label_fits_you";

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
{
    View view = inflater.inflate(R.layout.my_fragment, container, false);
    // This part is here to simulate a real Spinner since your example didn't include one
    final AppCompatSpinner spinner = view.findViewById(R.id.spinner);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, choices);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
        {
            spinnerPosition = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

    if (savedInstanceState != null)
        spinnerPosition = savedInstanceState.getInt(SPINNER_ITEM_POSITION);

    spinner.setSelection(spinnerPosition);
    return view;
}

@Override
public void onSaveInstanceState(@NonNull Bundle outState)
{
    // Save current position to bundle so you can retrieve it in onCreateView
    outState.putInt(SPINNER_ITEM_POSITION, spinnerPosition);
    super.onSaveInstanceState(outState);
}}