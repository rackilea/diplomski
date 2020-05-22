private void loginClick() {
    sUsername = eUsername.getText().toString();
    Intent intent = new Intent(this, MainActivity.class );
    intent.putExtra("containsUsername", sUsername); //first argument is the name of the string being     

    startActivity(intent);
}