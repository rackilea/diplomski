username = (EditText) findViewById(R.id.username);

String name = username.getText().toString();

// If you called your shared prefs 'UserDetails', storing the name would look like this:

UserDetails.setLoggedInUserName(getApplicationContext(), name);