@Override
public void onClick(View v) {

    int i = v.getId();

    try {
        if (i == R.id.signup && emailedittext.getText() != null && passwordedittext.getText() != null) {

            createAccount(emailedittext.getText().toString(), passwordedittext.getText().toString());

            String email = emailedittext.getText().toString();
            String password = passwordedittext.getText().toString();
        } else if (i == R.id.login && emailedittext.getText() != null && passwordedittext.getText() != null) {

            signIn(emailedittext.getText().toString(), passwordedittext.getText().toString());
            String email = emailedittext.getText().toString();
            String password = passwordedittext.getText().toString();
        } else if (i == R.id.signout) {
           signOut();
        }
    }catch(Exception e){
     e.printStackTrace();
    }
 }