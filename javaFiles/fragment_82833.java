public boolean validatePassword(String password){
    if(password.length() < 6){
        return false;
    }
    boolean foundLetter = false;
    boolean foundNumber = false;
    for(int i=0; i < password.length(); i++){
        char c = password.charAt(i);
        if(Character.isLetter(c)){
            foundLetter = true;
        }else if(Character.isDigit(c)){
            foundNumber = true;
        }else{
            // Isn't alpha-numeric.
            return false;
        }
    }
    return foundLetter && foundNumber;
}