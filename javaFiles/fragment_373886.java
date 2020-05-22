ParseUser user = new ParseUser();
user.setUsername("my name"); //in your case, text.getText().toString()
user.setPassword("my pass"); //in your case, text2.getText().toString()  
user.setEmail("email@example.com");

// other fields can be set just like with ParseObject
user.put("phone", "650-253-0000");

user.signUpInBackground(new SignUpCallback() {
public void done(ParseException e) {
   if (e == null) {
     // Hooray! Let them use the app now.
   } else {
     // Sign up didn't succeed. Look at the ParseException
     // to figure out what went wrong
   }
 }
});