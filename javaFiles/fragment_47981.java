public static class PlaceholderFragment extends Fragment {

    EditText editText1, editText2;

    public TextWatcher watcher = new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            checkFieldsForEmptyValues();
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);

        editText1 = (EditText) rootView.findViewById(R.id.editTitle);
        editText1.addTextChangedListener(watcher);
        editText2 = (EditText) rootView.findViewById(R.id.editCredit);
        editText2.addTextChangedListener(watcher);
        return rootView;
    }
}