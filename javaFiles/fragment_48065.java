//by the way you shouldn't start method names with upper case
public void submit (View view) {
        Intent myIntent = new Intent(CreateNewClass.this, MainActivity.class);
        EditText mEdit   = (EditText)findViewById(R.id.class_name);
        String name = mEdit.getText().toString();

        mEdit   = (EditText)findViewById(R.id.class_semester);
        String semester = mEdit.getText().toString();

        mEdit   = (EditText)findViewById(R.id.class_year);
        String year = mEdit.getText().toString();

        String buttonText = name + " " + semester + " " + year;

        myIntent.putExtra("button_text", buttonText);

        startActivity(myIntent);
    }