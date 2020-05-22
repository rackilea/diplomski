public void onAdd(View v) {
    EditText name = (EditText)findViewById(R.id.inputName);
    String nameString = name.getText().toString();
    EditText quantity = (EditText)findViewById(R.id.inputQuantity);
    String quantityString = quantity.getText().toString();
    db.addWorkout(new Workout(nameString,quantityString));
}