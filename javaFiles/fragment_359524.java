package myatm;

public class ATM {
    public double money;

    ATM(double moneyInATM) { // we can set up the number of money in ATM
        money = moneyInATM;

    }

    // checks pin code and card status(blocked or not)
    // if blocked should send exception
    // if pin is not correct should send exception too
    public boolean validateCard(Card card, int pinCode) {
        boolean ret = false;
        if ((card.checkPin(pinCode) == false) && (card.isBlocked() == false)) {
            ret = false;
        } else {
            if ((card.checkPin(pinCode) == true) && (card.isBlocked() == true))
                ret = true;
        }
        return ret;
    }

    Account acc = null;

    // returns the total ammount of money
    public double checkBalance() {
        return acc.getBalance();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    // method which is taking money from the account.
    // Should check if sum is less then money in atm
    public double getCash(double amount) {
        double sum = amount;
        if (this.checkBalance() > acc.getBalance()) {
            sum = (acc.getBalance() - sum);
        } else if (this.checkBalance() < acc.getBalance()) {
            throw new IllegalArgumentException("Not enough money in ATM");
        } else if (sum > acc.getBalance()) {
            throw new UnsupportedOperationException(
                    "Not enought money on your account");

        }
        return sum;
    }
}