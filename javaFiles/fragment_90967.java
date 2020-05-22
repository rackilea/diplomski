public String toString() {
    return String.format("BankAccount[owner: %s, balance: "
            + "%2$.2f, interest rate:"
            + " %3$.2f]", 
            myCustomerName, 
            myAccountBalance, myIntrestRate);
}