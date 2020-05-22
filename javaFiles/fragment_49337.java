for (Customer c : custList){
    if(c instanceof PayCust){
        PayCust pc = (PayCust) c;
        pc.getAccountType();
    }
}