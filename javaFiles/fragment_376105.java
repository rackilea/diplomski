//Client 

import java.util.ArrayList;
import java.util.Collection;

public class Client 
{
    private String clientName;
    private HashSet<Account> accounts;
public Client(String name)
{
    this.clientName = name;
    this.accounts = new HashSet<Account>();
}

public void addAccount(Account account) {

    accounts.add(account);
}

public String getClientName() {
    return clientName;
}

public void setClientName(String clientName) {
    this.clientName = clientName;
}

public Collection<Account> getAccounts() {
    return accounts;
}

public void setAccounts(HashSet<Account> accounts) {
    this.accounts = accounts;
}

public void printAccountDetails() {

    System.out.println("Account details :");
    int counter= 0;
    for(Account acc : accounts) {
        counter ++;
        System.out.println("Account details for Account '"+counter+"' :\n");
        System.out.println("Account Number : "+ acc.getAccNo() +" Balance :" + acc.getBalance() );
    }
}