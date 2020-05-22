public void sendReport(Context context) {
    EditText nameField = (EditText)findViewById(R.id.EditTextName);
    EditText emailField = (EditText)findViewById(R.id.EditTextEmail);
    EditText locationField = (EditText)findViewById(R.id.EditTextLocation);
    EditText dateField = (EditText)findViewById(R.id.EditTextDate);
    EditText bodyField = (EditText)findViewById(R.id.EditTextBody);

    if(!nameField.getText().toString().matches("") && !emailField.getText().toString().matches("") && !locationField.getText().toString().matches("") && !dateField.getText().toString().matches("") && !bodyField.getText().toString().matches("")) {
        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().putString("report_email", emailField.getText().toString()).apply();
        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().putString("report_name", nameField.getText().toString()).apply();

        String emailBody = "Name: "+nameField.getText()+"\n\n";
        emailBody += "Location: "+locationField.getText()+"\n\n";
        emailBody += "Time: "+dateField.getText()+"\n\n";
        emailBody += "Description: "+bodyField.getText();

        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);

        // set the type to 'email'
        emailIntent.setType("text/plain");
        String to[] = {emailField.getText().toString()};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);

        // the attachment - ArrayList populated in onActivityResult
        emailIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, userSelectedImageUriList);

        // the mail
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Report);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        startActivity(Intent.createChooser(emailIntent , "Send with..."));
        //finish();
    } else {
        Toast.makeText(this, getString(R.string.field_error), Toast.LENGTH_SHORT).show();
    }
}