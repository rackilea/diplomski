public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("Show Dialog");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        setContentView(button);
    }

    private void showDialog(){
        // Create the field to show in the Dialog:
        final EditText field = new EditText(this);

        // Now create the Dialog itself.
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Enter something")
                .setPositiveButton("O.K.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Main.this, "Submitted with \""+field.getText().toString()+"\"",
                                Toast.LENGTH_LONG).show();
                    }
                }).setCancelable(true).setView(field)
                .create();

        // The TextWatcher will look for changes to the Dialogs field.
        field.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence c, int i, int i2, int i3) {}
            @Override public void onTextChanged(CharSequence c, int i, int i2, int i3) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Will be called AFTER text has been changed.
                if (editable.toString().length() == 0){
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                } else {
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                }
            }
        });

        // Show the Dialog:
        dialog.show();
        // The button is initially deactivated, as the field is initially empty:
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
    }
}