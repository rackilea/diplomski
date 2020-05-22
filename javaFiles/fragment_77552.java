public CustomerTable create(controllers.beans.Customer cCustomers) {
                    this.customerId = cCustomers.getCustomerId();
                    this.accountId = cCustomers.getAccountId();
                    this.accountUsername =  cCustomers.getAccountUsername();
                    //Pass schema name as parameter
                    this.save("accounting");
                    return this;
}