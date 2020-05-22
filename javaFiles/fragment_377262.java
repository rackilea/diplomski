public boolean verifyUser( String username, char[] password ){
    List<Password> dbpass = getPasswords(username);
    boolean contained = dbpass.contains(new Password(password));
    overwriteWithNonsense(password);
    return contained;
}