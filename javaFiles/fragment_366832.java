public Account getAccount(int id){
    Account found = null;
    for (Account account : accounts) {
        if(((Account)account).getId()==id){
            found = ((Account)account); 
            break;
        }
    } 
    return found;
}