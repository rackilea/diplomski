for(Customer c : customers) {
    if (c.getNumber().equals(customerNumber)) {
        Iterator<Account> it = c.getAccounts().iterator();
        while(it.hasNext()) {
            Account a = it.next();
            if(a.getAccountId().equals(accountId)) {
                it.remove();
                break;                            
            }
        }
        break;
    }
}