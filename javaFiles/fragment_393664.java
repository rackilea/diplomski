checkIfUsernameExists(userName, new UserCallback() {
    @Override 
    public void onUserExists(Boolean exists) {
        if (!exists) {
            checkIfEmailExists(userEmail, new UserCallback() {
                // registerUser() if not exists 
             } 
        } 
     } 
} );