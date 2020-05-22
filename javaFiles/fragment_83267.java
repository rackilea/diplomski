public class YourActivity extends Activity {
    private LinearLayout holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_activity);
        //get a reference to the LinearLayout - the holder of our views
        holder = (LinearLayout) findViewById(R.id.holder);
        addNewEdit();
    }

    private void addNewEdit() {
        //inflate a new EditText from the layout
        final EditText newEdit = (EditText) getLayoutInflater().inflate(R.layout.new_edit, holder, false);
        //add it to the holder
        holder.addView(newEdit);
        //set the text change lisnter
        newEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here we decide if we have to add a new EditText view or to
                //remove the current
                if (s.length() == 0 && holder.getChildCount() > 1) {
                    holder.removeView(newEdit);
                } else if (s.length() > 0 && ((before + start) == 0)) {
                    addNewEdit();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}