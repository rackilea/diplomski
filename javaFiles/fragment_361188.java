public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.login);
        setContentView(R.layout.home_login);
        Button btn = (Button) findViewById(R.id.loginButton2);

        final EditText email_text = (EditText) findViewById(R.id.editText1);
        final EditText code_text = (EditText) findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                //check if user entered email and code, continue only if they have
                if (email_text.getText().length() > 0 && code_text.getText().length() > 0) {
                    //moved here, to avoid exception when text boxes are empty
                    final String userEmail = email_text.getText().toString();
                    final String userCode = code_text.getText().toString();

                    //changed from String x = "" because userCode is already a String
                    //and we don't have to change x to int, because we can compare 
                    //strings
                    String validCode = "";

                    //don't hardcode stop condition for i,
                    //instead, use the length of user entered string
                    for (int i = 0; i < userEmail.length(); i++) {
                        validCode += getNumber(userEmail.charAt(i));
                    }

                    //now we can compare userCode with validCode
                    if (userCode.equals(validCode)) {
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    } else {
                        TextView view = (TextView) findViewById(R.id.loginfailed);
                        view.setVisibility(View.VISIBLE);

                        //reset string in code_text editText
                        code_text.setText("");
                    }
                }
                //userEmail or/and userCode text boxes are empty, inform user
                else {
                    Toast.makeText(getApplicationContext(), "Please enter email and/or code", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }