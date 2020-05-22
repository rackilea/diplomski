public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_fingerp, container, false);

    EditText edit = (EditText) rootView.findViewById(R.id.editText);
    String edt = edit.getText().toString();
    File file = new File (myDir,edt);

    return rootView;
}