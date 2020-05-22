boolean success = false
for (LoginModel model : list) {
            ...
            if (username.equals(uName) && password.equals(pWord)) {
                      success = true;
                      ...
            } // no else here
 }
 if(!success) {
      // do the error-message stuff 
 }