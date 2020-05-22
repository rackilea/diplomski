public class Validation {

public int[] account = {1231, 1232, 1233, 1234};
public int[] pin = {1231, 1232, 1233, 1234};
private int accountBalance; // because this is a primitive type, default value is 0

public int getAccountBalance () { // get current balance value
    System.out.print("cuba setChangeBalance" + accountBalance);
    return accountBalance;
}

public void setAccountBalance(int value) { // set balance
    this.accountBalance= value;
}

public void minus(int value) { // remove from balance
    accountBalance-= value;
}

public void add(int value) { // add to balance
    accountBalance+= value;
}

}