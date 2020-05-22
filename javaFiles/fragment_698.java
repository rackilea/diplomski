public class MyActivity extends Activity {

private LinearLayout main;
private int id = 0;
private List<EditText> editTexts = new ArrayList<EditText>();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    main = new LinearLayout(this);
    main.setOrientation(LinearLayout.VERTICAL);

    Button addButton = new Button(this);
    addButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            addEditText();
        }
    });

    Button submit = new Button(this);
    submit.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            for (EditText editText : editTexts) {
                editText.getText().toString();
                // whatever u want to do with the strings
            }
        }
    });

    main.addView(addButton);
    main.addView(submit);
    setContentView(main);
}

private void addEditText() {
    LinearLayout editTextLayout = new LinearLayout(this);
    editTextLayout.setOrientation(LinearLayout.VERTICAL);
    main.addView(editTextLayout);

    EditText editText1 = new EditText(this);
    editText1.setId(id++);
    editTextLayout.addView(editText1);

    editTexts.add(editText1);

    EditText editText2 = new EditText(this);
    editText2.setId(id++);
    editTextLayout.addView(editText2);

    editTexts.add(editText2);

}