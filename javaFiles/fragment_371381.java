public class Page1Fragment extends AbstractFillerFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = // inflate XML resource ...
        yourEditText = (EditText) view.findViewById(...);
        // other relevant code ....
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
       yourEditText.setText(dataExposer.exposeFiller.setPageX$DataY());
       // some code for EditText.addTextChangedListener(new TextWatcher() could look like:
        yourEditText.addTextChangedListener(new TextWatcher() {

          public void afterTextChanged(Editable s) {

            dataExposer.exposeFiller().setPage1$Data0(s.toString());

          }

          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          public void onTextChanged(CharSequence s, int start, int before, int count) {}
       });
    }
}