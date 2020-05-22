public MyDialogFragment extends DialogFragment {
    private static final String ARG_NAME = "name";
    private static final String ARG_TAG = "tag";
    public MyDialogFragment newInstance(String name, String tag) {
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_TAG, tag);

        MyDialogFragment frag = new MyDialogFragment();
        frag.setArguments(args);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v_iew = inflater.inflate(R.layout.fragment_inputdialog, null);

        nameInputField = (EditText) v_iew.findViewById(R.id.inputdialogname);
        tagInputField = (EditText) v_iew.findViewById(R.id.inputdialogtag);

        nameInputField.setText(getArguments().getString(ARG_NAME, ""));
        tagInputField.setText(getArguments().getString(ARG_TAG, ""));
    }
}