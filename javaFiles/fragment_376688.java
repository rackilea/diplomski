private void SaveAccountInformation() {

    ProgressDialog loadingBar = new ProgressDialog(RegistrationActivity.this);
    loadingBar.setMessage("Please wait while we are registering you in our system.");
    loadingBar.show();
    loadingBar.setCanceledOnTouchOutside(true);

    String firstname = RegisterFirstName.getText().toString();
    String lastname = RegisterLastName.getText().toString();

    if (TextUtils.isEmpty(firstname))
        Toast.makeText(RegistrationActivity.this, "Enter your first name.", Toast.LENGTH_SHORT).show();

    else if (TextUtils.isEmpty(lastname))
        Toast.makeText(RegistrationActivity.this, "Last name is required.", Toast.LENGTH_SHORT).show();

    else {

        String userid = databaseUser.push().getKey();
        User user = new User(firstname, lastname);

        databaseUser.child(userid).setValue(user)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(RegistrationActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegistrationActivity.this, "Failed to save the data", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }); 

        Intent HomeIntent = new Intent(RegistrationActivity.this, home.class);
        HomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(HomeIntent);
        finish();
    }
}