public boolean check() {
    for (int i = 0; i < accounts.length; i++) {
        if ((username.equals(accounts[i][0])) && (password.equals(accounts[i][1]))) 
            return true;
    }
    return false;
}