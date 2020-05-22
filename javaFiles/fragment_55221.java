public CRM() {}

public CRM setNumber(String number) { 
    this.number = number;
    return this;
}

public CRM setDealer(String dealer) { 
    this.dealer = dealer;
    return this;
}

//and use it like this
CRM crm = new CRM().setNumber("123").setDealer("dealer"); //et cetera