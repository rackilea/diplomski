public void submitButtonClicked(View view) {
    String usernamevar = username.getText().toString();
    String agevar = age.getText().toString();
    String weightvar = weight.getText().toString();
    String heightvar = height.getText().toString();
    String caloriesvar = calories.getText().toString();
    String proteinvar = protein.getText().toString();
    String carbsvar = carbs.getText().toString();
    String fatvar = fat.getText().toString();

    AddStats entry = new AddStats(AddStatsForm.this);
    entry.open();
    entry.createEntry(usernamevar ,agevar, weightvar, heightvar, caloriesvar, proteinvar, carbsvar, fatvar);
    entry.close();
}