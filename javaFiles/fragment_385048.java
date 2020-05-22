public class MyActivity extends Activity {


// declares vars
final Context context = this;
private Button addClassBtn;
private Button createBtn;
public EditText classNameInput;
private String classTextName;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
       // initializes var
    final LayoutInflater classInfo = getLayoutInflater();
    addClassBtn = (Button) findViewById(R.id.classBtn);

    // creates a alert box with a text view when button is clicked
    addClassBtn.setOnClickListener(
        new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            View dialogView = classInfo.inflate(R.layout.class_info, null);

            setDialogViews(dialogView);

            builder.setView(dialogView);

            builder.setTitle("Add Class");

            AlertDialog diaBox = builder.create();

            diaBox.show();

        }
    });


    private void setDialogViews(View dialogView){
        classNameInput = (EditText) dialogView.findViewById(R.id.classNameInput);
        createBtn = (Button) dialogView.findViewById(R.id.createBtn);

        //classNameInput is extracted to a variable
        createBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String className;

                        className = classNameInput.getText().toString();

                        Log.v("EditText", className);

                    }
                });
    }