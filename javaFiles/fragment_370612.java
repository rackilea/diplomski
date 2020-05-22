@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_binary_numbers, container, false);
    EditText et_input = (EditText) view.findViewById(R.id.et_input);
    et_input.setText("TEST");

    // Inflate the layout for this fragment
    return view;
}