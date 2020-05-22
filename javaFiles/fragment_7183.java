public void onClick(View arg0) {
    ...
    ...
    String decryptedUser;
    String decryptedPass;
    try {
        user = sp.getString("USERNAME_KEY", null);
        decryptedUser = decrypt(user, key);  
        pass = sp.getString("PASSWORD_KEY", null);
        decryptedPass = decrypt(pass, key);
        /* Your if statements follow from here */
        ...
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }   

}