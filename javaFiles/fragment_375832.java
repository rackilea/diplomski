final String uid = ref.push().getKey(); //OR call for your randomuid() methodd if you prefer
register_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final String username = txt_username.getText().toString().trim();
        final String password = txt_password.getText().toString().trim();
        final String email = txt_email.getText().toString();

        register_btn.setEnabled(false);

        if(username.length() < 3) {
            Toast.makeText(RegisterActivity.this, "Username must be atleast 3 characters long!", Toast.LENGTH_SHORT).show();
            register_btn.setEnabled(true);
            return;
        }
        if(password.length() < 6) {
            Toast.makeText(RegisterActivity.this, "Password must be atleast 6 characters long!", Toast.LENGTH_SHORT).show();
            register_btn.setEnabled(true);
            return;
        }

        if(!validateEmail(email)) {
            Toast.makeText(RegisterActivity.this, "The email entered is invalid", Toast.LENGTH_SHORT).show();
            register_btn.setEnabled(true);
            return;
        }

        for(Map.Entry<String, Object> e : users.entrySet()) {
            Map<String, Object> user = (HashMap<String, Object>) e.getValue();

            if(user.get("username").toString().equalsIgnoreCase(username)) {
                Toast.makeText(RegisterActivity.this, "This username already exists", Toast.LENGTH_SHORT).show();
                register_btn.setEnabled(true);
                return;
            }

            if(user.get("email").toString().equalsIgnoreCase(email)) {
                Toast.makeText(RegisterActivity.this, "This email already exists", Toast.LENGTH_SHORT).show();
                register_btn.setEnabled(true);
                return;
            }

            final int id = users.size() + 1;

            Map<String, Object> newUser = createUser(id, username, password, email);

            ref.child(uid).setValue(newUser);

            Toast.makeText(RegisterActivity.this, "Successfully registered!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);

            register_btn.setEnabled(true);

        }
    }
});