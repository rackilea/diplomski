public class SavingAccount implements IAccount {
public static int SAVING_INT = 5;

public SavingAccount() {
    System.out.println("Default constructor invoked!!");
}

@Override
public int calculateInterest(int amount, int duration) {
    return (amount*duration*SAVING_INT)/100;
}