public Account getAccount(int id){
    for (Account account : accounts) {
        if(((Account)account).getId()==id){
            return ((Account)account); 
        }
    } 
    return null;
}