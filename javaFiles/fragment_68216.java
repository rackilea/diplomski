private static final String MYKEY = "myEditText1";
private static final String DEFAULT_TEXT = "I'm a button";

private String newNmOne = DEFAULT_TEXT;

void changeNameOne(){
        lidOne=btn.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Change Name");
        alert.setMessage("Type in the text you want to set.");
        final EditText ec = new EditText(this);
        alert.setView(ec);
        ec.setText(lidOne);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                newNmOne = ec.getText().toString();
                btn.setText(newNmOne);
                prefs.putString(MYKEY, newNmOne);////////////here this can be done in onpause too
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                btn.setText(lidOne); //not needed
            }

        });
        alert.show();
    }

    public void onResume(){
         newNmOne = prefs.getString(MYKEY, DEFAULT_TEXT);//if not found set default text
    btn.setText(newNmOne);
    }