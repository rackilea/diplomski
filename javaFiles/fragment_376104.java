//Account

public class Account
{
    private int balance;
    private String accNo;

    public Account(int money,String num) {
    balance = money;
    accNo = num;
}

public int getBalance() {
        return balance;
    }

public void setBalance(int balance) {
    this.balance = balance;
}

public String getAccNo() {
    return accNo;
}

public void setAccNo(String accNo) {
    this.accNo = accNo;
}