private void handleSignInResult(GoogleSignInResult result) {
           Log.d(TAG, "handleSignInResult:" + result.isSuccess());
           if (result.isSuccess()) {
               // Signed in successfully.
               GoogleSignInAccount acct = result.getSignInAccount();
               String email = acct.getEmail();
               String[] split = s.split("@");
               String domain = split[1]; //This Will Give You The Domain After '@'
               if(domain.equals("companyname.com"))
               {
                 //Proceed Ahead.
               }
                else
               {
                 //Show User Warning UI.
               }
           } else {
               // Signed out, show unauthenticated UI.
               updateUI(false);
           }
       }