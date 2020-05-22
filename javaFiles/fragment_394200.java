@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Get the data
    if (getArguments() != null) {

        Bundle data = getArguments();
        int id = data.getInt("id");

        // Get the corresponding textview from parent activity
        textView = (TextView) getActivity().findViewById(id);
    }
}