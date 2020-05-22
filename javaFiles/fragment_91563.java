@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_id, container);
    EditText editText = (EditText)view.findViewById(R.id.edit_text_id);

    // show soft keyboard
    editText.requestFocus();
    getDialog().getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    return view;
}