btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstname = etFname.getText().toString();
                final String lastname = etLname.getText().toString();
                final String email = etEmail.getText().toString();
                final String phone = etContact.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String department = sel_spinner;