CardView manager=findViewById(R.id.manager_card);
    manager.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


                final Dialog login = new Dialog(this);
                // Set GUI of login screen
                login.setContentView(R.layout.login_gui);
                login.setTitle("Login to Pulse 7");

                // Init button of login GUI
                Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
                Button btnCancel = (Button) login.findViewById(R.id.btnCancel);
                final EditText txtUsername = (EditText)login.findViewById(R.id.txtUsername);
                final EditText txtPassword = (EditText)login.findViewById(R.id.txtPassword);



                     // Attached listener for login GUI button
            btnLogin.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(txtUsername.getText().toString().trim().equals("admin")  && txtPassword.getText().toString().trim().equals("admin"))
                    {
                        // Validate Your login credential here than display message
                        Toast.makeText(SignInActivity.this,
                                "Login Sucessfull", Toast.LENGTH_LONG).show();

                        // Redirect to dashboard / home screen.
                        login.dismiss();
                        Intent intent = new Intent(getApplicationContext(), ManagerMenu.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(SignInActivity.this,
                                "Please enter valid Username and Password", Toast.LENGTH_LONG).show();

                    }
                }
            });
            btnCancel.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    login.dismiss();
                }
            });

            // Make dialog box visible.
            login.show();


        }
    });